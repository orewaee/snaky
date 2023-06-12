val ktorVersion: String by project
val kotlinVersion: String by project

plugins {
    application

    kotlin("jvm") version "1.8.21"
    kotlin("plugin.serialization") version "1.8.21"

    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "ru.orewaee"
version = "1.0.0"

repositories {
    mavenCentral()

    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    implementation("com.github.orewaee:krayon:1.1.0")
}

application.mainClass.set("MainKt")

tasks {
    shadowJar {
        archiveFileName.set("snaky.jar")
    }
}
