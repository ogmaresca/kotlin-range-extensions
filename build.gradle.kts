repositories {
	gradlePluginPortal()
	mavenCentral()
}

plugins {
	kotlin("multiplatform") version "kotlinVersion"
	id("com.github.spotbugs") version "spotbugsVersion"
	id("com.diffplug.spotless") version "spotlessVersion"
}

apply(plugin = "com.github.spotbugs")
apply(plugin = "com.diffplug.spotless")

group = "com.ogm.kotlin.range.extensions"
version = "0.1.0"

repositories {
	mavenCentral()
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions {
				allWarningsAsErrors = true
				freeCompilerArgs = listOf(
					"-Xjsr305=warn",
					// "-Xemit-java-type-annotations",
					"-java-parameters",
					"-Xjvm-default=all-compatibility",
				)
				apiVersion = "1.9"
				languageVersion = "1.9"
				jvmTarget = "1.8"
			}
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

	file("$rootDir/src").listFiles { it: File -> it.isDirectory }.forEach { sourceSet ->
		logger.info("Processing $sourceSet templates")

		val packageDir = "$sourceSet/kotlin/${packageName.replace('.', '/')}"

		fileTree(packageDir) { include("*.generated.kt") }.forEach {
			logger.info("Deleting generated code file $it")
			it.delete()
		}

		fileTree("$sourceSet/templates") { include("*.template") }.forEach { template ->
			val lines = template.readLines()

			val declaration = lines.first().split("=", limit = 2)
			val variable = declaration.first()
			val values = declaration.last().split(",")

			values.forEach {
				val templatedFile = "$header${lines.drop(1).joinToString("\n").replace("\${$variable}", it)}\n"
				val kotlinFile = "$packageDir/$it${template.nameWithoutExtension}.generated.kt"
				logger.info("Generating file $kotlinFile")
				file(kotlinFile).writeText(templatedFile, Charsets.UTF_8)
			}
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
