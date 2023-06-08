val ktorVersion: String by project
val kotlinVersion: String by project

plugins {
    application

    kotlin("jvm") version "1.8.21"
    kotlin("plugin.serialization") version "1.8.21"

    id("com.github.johnrengelman.shadow") version "7.1.2"

    id("io.ktor.plugin") version "2.3.1"
}

group = "ru.orewaee"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    implementation("io.ktor:ktor-server-cors-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
}

application.mainClass.set("MainKt")

tasks {
    shadowJar {
        archiveFileName.set("snaky.jar")
    }
}
