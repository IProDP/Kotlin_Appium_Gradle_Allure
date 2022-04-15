import org.jetbrains.kotlin.contracts.model.structure.UNKNOWN_COMPUTATION.type
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.qameta.allure.gradle.allure:allure-plugin: 2.9.4")
    }
}

plugins {
    java
    application
    id("io.qameta.allure") version "2.9.4"
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.spring") version "1.4.0"
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

apply(plugin = "java")
apply(plugin = "io.qameta.allure")
apply(plugin = "kotlin-allopen")
allOpen {
    annotation("com.bns.starter.steps.StepContainer")
}

group = "me.prots"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri ("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

dependencies {
    //kotlin-tests
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-js:1.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.0")
    //cucumber
    implementation("io.cucumber:cucumber-parent:2.1.2")
    implementation("io.cucumber:cucumber-junit:6.11.0")
    implementation("io.cucumber:cucumber-jvm:6.11.0")
    implementation("io.cucumber:cucumber-java8:6.11.0")
    implementation("net.masterthought:cucumber-reporting:5.7.0")
    //junit
    implementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
    implementation("org.testcontainers:junit-jupiter:1.16.0")
    implementation("org.testifyproject.junit5:junit5:1.0.6")
    //selenium
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-server:3.141.59")
    //appium
    implementation("io.appium:java-client:7.5.1")
    implementation("io.flux-capacitor:java-client:v0.1")
    implementation("ly.count.sdk:java:20.11.0")
    //gradle
    implementation("com.ullink.gradle:gradle-nunit-plugin:1.13")
    //reports
    implementation("com.aventstack:extentreports:5.0.8")
    compile ("com.google.guava:guava:29.0-jre")
    //allure reporter
    implementation("io.qameta.allure:allure-java-commons:2.16.1")
    implementation("io.qameta.allure:allure-attachments:2.16.1")
    implementation("io.qameta.allure:allure-selenide:2.16.1")
    //selenium
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-server:3.141.59")
}

tasks.test {
    useJUnitPlatform()
    systemProperty ("allure.results.directory", "$projectDir/build/allure-results")
    testLogging {
        events ("PASSED", "FAILED", "SKIPPED", "STANDARD_OUT", "STANDARD_ERROR")
    }
    testLogging.showStandardStreams = true
    dependsOn ("cleanTest")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

allure {
    val version = "2.9.4"
    val autoconfigure = true
    val aspectjweaver = true
}

val cucumberRuntime: Configuration by configurations.creating {
    extendsFrom(configurations.testImplementation.get())
}

//Mobile application

arrayOf("Android", "IOS").forEach { platform ->
    arrayOf("AppOne_Device", "AppOne_Emulator", "AppTwo_Device", "AppTwo_Emulator").forEach { project ->
        arrayOf("@Smoke", "@Manual", "@Test").forEach { tags ->
            tasks.register<JavaExec>("test$platform$project$tags") {
                systemProperty("allure.results.directory", "$projectDir/build/allure-results")
                mainClass.set("io.cucumber.core.cli.Main")
                classpath =
                    cucumberRuntime + sourceSets.main.get().output + sourceSets.main.get().output + sourceSets.test.get().output

                when (project) {
                    "AppOne_Device" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--plugin", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                            "--glue", "Mobile_UI.AppOneScreenInit.FeatureSteps", "src/test/kotlin/Mobile_UI/AppOneScreenInit/FeatureFiles",
                            "--tags", tags
                        )
                    }
                    "AppOne_Emulator" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--plugin", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                            "--glue", "Mobile_UI.AppOneScreenInit.FeatureSteps", "src/test/kotlin/Mobile_UI/AppOneScreenInit/FeatureFiles",
                            "--tags", tags
                        )
                    }
                    "AppTwo_Device" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--plugin", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                            "--glue", "Mobile_UI.AppTwoPageFactory.FeatureSteps", "src/test/kotlin/Mobile_UI/AppTwoPageFactory/FeatureFiles",
                            "--tags", tags
                        )
                    }
                    "AppTwo_Emulator" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--plugin", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                            "--glue", "Mobile_UI.AppTwoPageFactory.FeatureSteps", "src/test/kotlin/Mobile_UI/AppTwoPageFactory/FeatureFiles",
                            "--tags", tags
                        )
                    }
                }
                systemProperty("platform", platform)
                systemProperty("project", project)
                systemProperty("tags", tags)
            }
        }
    }
}

//Web Application

arrayOf("Chrome", "Edge").forEach { browser ->
    arrayOf("AppOneWeb").forEach { projectWeb ->
        arrayOf("@Smoke", "@Manual", "@Test").forEach { tagsWeb ->
            tasks.register<JavaExec>("testWeb$browser$projectWeb$tagsWeb") {
                systemProperty("allure.results.directory", "$projectDir/build/allure-results")
                mainClass.set("io.cucumber.core.cli.Main")
                classpath =
                    cucumberRuntime + sourceSets.main.get().output + sourceSets.main.get().output + sourceSets.test.get().output

                when (projectWeb) {
                    "AppOneWeb" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--plugin", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                            "--glue", "Web_UI.AppOneWeb.FeatureSteps", "src/test/kotlin/Web_UI/AppOneWeb/FeatureFiles",
                            "--tags", tagsWeb
                        )
                    }
                }
                systemProperty("browser", browser)
                systemProperty("projectWeb", projectWeb)
                systemProperty("tagsWeb", tagsWeb)
            }
        }
    }
}

application {
    mainClass.set("MainKt")
}