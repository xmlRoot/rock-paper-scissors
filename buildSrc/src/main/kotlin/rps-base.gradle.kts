plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-core:1.4.3")
    implementation("ch.qos.logback:logback-classic:1.4.3")
    implementation("org.slf4j:slf4j-api:2.0.3")

    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
}