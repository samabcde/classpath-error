import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // add dependency on the jar
    implementation(project(":app"))
    // add dependency on the resources/main
    implementation(project(":app", "testOutput"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType(KotlinCompile::class.java) {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.test {
    useJUnitPlatform()
}
// for debugging the classpath
configurations["testCompileClasspath"].resolvedConfiguration.files.forEach { println(it) }