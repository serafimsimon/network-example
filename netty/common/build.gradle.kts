plugins {
    id("java")
}

version = "1.0-SNAPSHOT"

dependencies {
    implementation("io.netty:netty-all:4.1.59.Final")

    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.3")
}

repositories {
    mavenCentral()
}