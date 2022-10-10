plugins {
    `java-library`
    id("io.freefair.lombok") version "6.5.1"
    id("rps-base")
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":common")!!)
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
