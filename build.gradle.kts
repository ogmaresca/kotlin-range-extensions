repositories {
	gradlePluginPortal()
	mavenCentral()
}

plugins {
	val kotlinVersion = "1.7.10"
	val spotbugsVersion = "5.0.12"

	kotlin("multiplatform") version kotlinVersion
	id("com.github.spotbugs") version spotbugsVersion
}

apply(plugin = "com.github.spotbugs")

group = "com.ogm.kotlin.range.extensions"
version = "0.1.0"

repositories { 
    mavenCentral()
}

kotlin {
	// Can't use AssertJ >= 3.21.0 because of https://github.com/assertj/assertj/issues/2361
	val assertJVersion = "3.20.2"
	val junitVersion = "5.9.0"

	jvm {
		compilations.all {
			kotlinOptions {
				allWarningsAsErrors = true
				freeCompilerArgs = listOf("-java-parameters")
				apiVersion = "1.5"
				languageVersion = "1.7"
				jvmTarget = "1.8"
			}
		}
	}

	sourceSets {
		@Suppress("UNUSED_VARIABLE") val commonMain by getting {}
		@Suppress("UNUSED_VARIABLE") val commonTest by getting {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

		@Suppress("UNUSED_VARIABLE") val jvmMain by getting {}
		@Suppress("UNUSED_VARIABLE") val jvmTest by getting {
			dependencies {
				implementation(kotlin("test"))
				implementation("org.assertj:assertj-core:$assertJVersion")
				implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
				implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
				runtimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
			}
		}
	}
}

spotbugs {
	showProgress.set(true)
	excludeFilter.set(project.file("config/spotbugs/exclude.xml"))
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
			enabled = true
			setStylesheet("fancy-hist.xsl")
		}
		reports.create("html") {
			enabled = true
			setStylesheet("fancy-hist.xsl")
		}
	}
}
