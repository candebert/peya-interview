group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.9.0"
    application
}

repositories {
    mavenCentral()
}

object Versions {
    const val JUNIT_VERSION = "5.10.0"
    const val MOCKITO_VERSION = "3.5.2"
    const val VERTX_VERSION = "4.4.1"
}

dependencies {
    testDependencies()
    vertxDependencies()
}

fun DependencyHandlerScope.testDependencies() {
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:${Versions.JUNIT_VERSION}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-inline:${Versions.MOCKITO_VERSION}")
}

fun DependencyHandlerScope.vertxDependencies() {
    implementation("io.vertx:vertx-core:${Versions.VERTX_VERSION}")
    implementation("io.vertx:vertx-web:${Versions.VERTX_VERSION}")
    implementation("io.vertx:vertx-web-client:${Versions.VERTX_VERSION}")
    implementation("io.vertx:vertx-web-openapi:${Versions.VERTX_VERSION}")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}