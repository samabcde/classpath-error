plugins {
    // 1.8.10 will work
    val kotlinVersion = "1.8.20"

    id("org.springframework.boot") version ("3.0.6") apply (false)
    id("io.spring.dependency-management") version ("1.1.0") apply (false)
    id("org.jetbrains.kotlin.jvm") version (kotlinVersion) apply (false)
    id("org.jetbrains.kotlin.plugin.spring") version (kotlinVersion) apply (false)
}
group = "com.example"
version = "0.0.1-SNAPSHOT"


repositories {
    mavenCentral()
}
subprojects {
    apply {
        apply(plugin = "java")
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    }
}