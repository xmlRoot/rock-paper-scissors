plugins {
    application
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    implementation(project(":engine"))
    implementation(project(":bot"))
    implementation("info.picocli:picocli:4.6.3")

}

application {
    mainClass.set("com.tyntec.interview.rps.app.RpsGame")
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// create fat jar
tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to application.mainClass))
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val sourcesMain = sourceSets.main.get().output
    val contents = configurations.runtimeClasspath.get().map { file ->
        file.takeIf { it.isDirectory } ?: zipTree(file)
    }
    from(contents + sourcesMain)
}