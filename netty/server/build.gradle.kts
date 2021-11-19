plugins {
    id("java")
    id("application")
}

version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.lezenford.netty.server.Server")
}

dependencies {
    // https://mvnrepository.com/artifact/io.netty/netty-all
    implementation("io.netty:netty-all:4.1.59.Final")
    implementation(project(":netty:common"))
}

repositories {
    mavenCentral()
}