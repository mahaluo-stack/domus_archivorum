plugins {
    kotlin("jvm") version "1.9.22"
    `maven-publish`
}

group = "org.exemplaria"
version = "1.0.2"

repositories {
    mavenCentral()
}

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            from(components["kotlin"])
            artifactId = "scriptorium-exemplaria"
        }
    }
    repositories {
        mavenLocal()
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe:0.10.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(20)
}

