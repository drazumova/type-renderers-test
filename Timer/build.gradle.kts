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

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}

application {
    mainClass.set("com.test.task.MainKt")
}