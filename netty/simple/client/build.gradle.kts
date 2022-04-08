plugins {
    id("java")
    id("application")
}

version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.lezenford.netty.simple.client.Client")
}

dependencies {
    // https://mvnrepository.com/artifact/io.netty/netty-all
    implementation("io.netty:netty-all:4.1.75.Final")
}

repositories {
    mavenCentral()
}