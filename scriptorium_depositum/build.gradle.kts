plugins {
    kotlin("jvm") version "2.2.0"
}

group = "org.depositum"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":scriptorium_infrastructura"))
    implementation(project(":scriptorium_exemplaria"))

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaExec> {
    systemProperty("java.library.path", "C:/mssql-jdbc/")
}

kotlin {
    jvmToolchain(20)
}