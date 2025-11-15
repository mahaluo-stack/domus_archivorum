plugins {
    kotlin("jvm") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe:0.10.0")
    implementation("com.microsoft.sqlserver:mssql-jdbc:13.2.1.jre11")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}