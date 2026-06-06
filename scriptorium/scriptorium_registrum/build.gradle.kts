plugins {
    kotlin("jvm") version "2.2.0"
}

group = "org.registrum"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":scriptorium_exemplaria"))
    implementation(project(":scriptorium_depositum"))
    implementation(project(":scriptorium_ministerium"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")

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