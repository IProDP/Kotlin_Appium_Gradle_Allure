import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.0"
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

apply(plugin = "java")
//apply(plugin = "kotlin-allopen")

group = "me.prots"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    //kotlin-tests
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.4.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-js:1.4.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.0")
    //cucumber
    implementation("io.cucumber:cucumber-parent:2.1.2")
    implementation("io.cucumber:cucumber-junit:6.11.0")
    implementation("io.cucumber:cucumber-jvm:6.11.0")
    implementation("io.cucumber:cucumber-java8:6.11.0")
    //implementation("io.cucumber.kotlin:6.11.0")

    implementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
    implementation("org.testcontainers:junit-jupiter:1.16.0")
}

tasks.test {
    useJUnit()
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

val cucumberRuntime: Configuration by configurations.creating {
    extendsFrom(configurations.testImplementation.get())
}

//Mobile application
arrayOf("Android", "IOS").forEach { platform ->
    arrayOf("AppOne_Device", "AppOne_Emulator", "AppTwo_Device", "AppTwo_Emulator").forEach { project ->
        arrayOf("@Smoke", "@Manual", "@Test").forEach { tags ->
            tasks.register<JavaExec>("test$platform$project$tags") {
                mainClass.set("io.cucumber.core.cli.Main")
                classpath =
                    cucumberRuntime + sourceSets.main.get().output + sourceSets.main.get().output + sourceSets.test.get().output

                when (project) {
                    "AppOneMobile_Device" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--glue", "AppOne.FeatureSteps", "src/test/kotlin/AppOne/FeatureFiles",
                            "--tags", tags
                        )
                    }
                    "AppOneMobile_Device_Emulator" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--glue", "AppOne.FeatureSteps", "src/test/kotlin/AppOne/FeatureFiles",
                            "--tags", tags
                        )
                    }
                    "AppTwoMobile_Device" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--glue", "AppTwo.FeatureSteps", "src/test/kotlin/AppTwo/FeatureFiles",
                            "--tags", tags
                        )
                    }
                    "AppTwoMobile_Emulator" -> {
                        args = listOf(
                            "--plugin", "pretty",
                            "--plugin", "html:cucumber-report/target/cucumber-report.html",
                            "--glue", "AppTwo.FeatureSteps", "src/test/kotlin/AppTwo/FeatureFiles",
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

application {
    mainClass.set("MainKt")
}