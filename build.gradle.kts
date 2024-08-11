plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.24"
}

group = "ru.iglaz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
}

tasks.test {
    useJUnitPlatform()
}
