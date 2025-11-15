plugins {
    kotlin("jvm") version "2.2.0"
}

group = "org.nexus"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe:1.0.0-dev-8856")
    implementation("org.jetbrains.kotlinx:dataframe-jdbc:1.0.0-dev-8856")
    implementation("com.microsoft.sqlserver:mssql-jdbc:13.2.1.jre11")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("com.zaxxer:HikariCP:7.0.2")
    implementation("org.exemplaria:scriptorium-exemplaria:1.0.2")

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