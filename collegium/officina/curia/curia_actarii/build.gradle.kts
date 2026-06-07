plugins {
    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization")
}

val ktorVersion = "3.1.3"
group = "org.curia_actarii"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe:0.10.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("com.microsoft.sqlserver:mssql-jdbc:13.2.1.jre11")

    implementation("io.ktor:ktor-server-core-jvm:${ktorVersion}")
    implementation("io.ktor:ktor-server-netty-jvm:${ktorVersion}")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:${ktorVersion}")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:${ktorVersion}")

    implementation(project(":scriptorium_registrum"))
    implementation(project(":scriptorium_exemplaria"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}