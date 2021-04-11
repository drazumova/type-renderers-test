import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    application
}

group = "com.test.task"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly(files("build/classes/kotlin/main"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "com.test.task.MainKt"
}