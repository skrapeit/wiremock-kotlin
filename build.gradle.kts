plugins {
    kotlin("jvm") version "1.4.20"
}

group = "it.skrape"
version = "0.1.0"

val junitVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.tomakehurst:wiremock:+")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
    }
}


