import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

repositories {
	gradlePluginPortal()
	mavenCentral()
}

plugins {
	kotlin("multiplatform") version "kotlinVersion"
	id("com.github.spotbugs") version "spotbugsVersion" apply true
	id("com.diffplug.spotless") version "spotlessVersion" apply true
}

apply(plugin = "com.github.spotbugs")
apply(plugin = "com.diffplug.spotless")

group = "com.ogm.kotlin.range.extensions"
version = "0.1.0"

repositories {
	mavenCentral()
}

kotlin {
	@OptIn(ExperimentalKotlinGradlePluginApi::class)
	compilerOptions {
		allWarningsAsErrors = true
		freeCompilerArgs =
			listOf(
				"-Xjsr305=warn",
				// "-Xemit-java-type-annotations",
				"-java-parameters",
				"-Xjvm-default=all-compatibility",
			)
		apiVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_1_9
		languageVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0
	}

	jvm {
		@OptIn(ExperimentalKotlinGradlePluginApi::class)
		compilerOptions {
			jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8
		}
	}

	sourceSets {
		@Suppress("UNUSED_VARIABLE")
		val commonMain by getting {}

		@Suppress("UNUSED_VARIABLE")
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		@Suppress("UNUSED_VARIABLE")
		val jvmMain by getting {}

		@Suppress("UNUSED_VARIABLE")
		val jvmTest by getting {
			dependencies {
				val assertJVersion: String by project
				val junitVersion: String by project

				implementation(kotlin("test"))
				implementation("org.assertj:assertj-core:$assertJVersion")
				implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
				implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
				runtimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
			}
		}
	}
}

val packageName = "com.ogm.kotlin.range.extensions"

val generateCode by tasks.registering {
	logger.info("Starting generateCode task")

	val header = "/** Generated file */\n\npackage $packageName\n\n"
	val declarationRegex = Regex("^[A-Z_]+=.+$")

	file("$rootDir/src").listFiles { it: File -> it.isDirectory }?.forEach { sourceSet ->
		logger.info("Processing $sourceSet templates")

		val packageDir = "$sourceSet/kotlin/${packageName.replace('.', '/')}"

		fileTree(packageDir) { include("*.generated.kt") }.forEach {
			logger.info("Deleting generated code file $it")
			it.delete()
		}

		fileTree("$sourceSet/templates") { include("*.template") }.forEach { templateFile ->
			val lines = templateFile.readLines()

			val declarations = lines
				.takeWhile { it.matches(declarationRegex) }
				.associateTo(linkedMapOf()) {
					val declaration = it.split("=", limit = 2)
					declaration.first() to declaration.last().split(",")
				}

			check(declarations.values.map { it.size }.toSet().size == 1) {
				"Invalid variables on $templateFile"
			}

			val imports = lines.drop(declarations.size).takeWhile { it.startsWith("import ") || it.isEmpty() }

			val template = lines.drop(declarations.size + imports.size).joinToString("\n")

			val templatedFile = header + imports.joinToString("\n") + "\n" + (0 until declarations.values.first().size).map { i ->
				declarations.entries.fold(template) { acc, (variable, values) ->
					acc.replace("\${$variable}", values[i])
				}
			}.joinToString("\n\n") + "\n"

			val kotlinFile = "$packageDir/${templateFile.nameWithoutExtension}.generated.kt"
			logger.info("Generating file $kotlinFile")
			file(kotlinFile).writeText(templatedFile, Charsets.UTF_8)
		}
	}
}

spotless {
	var editorconfigLineIsForKotlin = false
	val editorConfigRules = file(".editorconfig")
		.readLines()
		.mapNotNull {
			if (it.startsWith('[') && it.endsWith(']')) {
				editorconfigLineIsForKotlin = it == "[*]" || it == "[{*.kt, *.kts}]"
				null
			} else if (editorconfigLineIsForKotlin && it.contains('=')) {
				val (rule, value) = it.split('=')
				rule.trim() to value.trim()
			} else {
				null
			}
		}
		.toMap()

	println("editorConfigRules == $editorConfigRules")

	kotlin {
		target("**/*.kt")
		ktlint().editorConfigOverride(editorConfigRules)
	}

	kotlinGradle {
		ktlint().editorConfigOverride(editorConfigRules)
	}
}

tasks {
	withType<Test>().configureEach {
		testLogging {
			displayGranularity = 2
			events = org.gradle.api.tasks.testing.logging.TestLogEvent.values().toSet()
			exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
			showCauses = true
			showExceptions = true
			showStackTraces = true
			showStandardStreams = true
		}

		useJUnitPlatform()
	}

	withType<com.github.spotbugs.snom.SpotBugsTask>().configureEach {
		showProgress.set(true)
		effort.set(com.github.spotbugs.snom.Effort.MAX)
		showStackTraces = true
		reports.create("xml") {
			required.set(true)
			setStylesheet("fancy-hist.xsl")
		}
		reports.create("html") {
			required.set(true)
			setStylesheet("fancy-hist.xsl")
		}
	}
}
