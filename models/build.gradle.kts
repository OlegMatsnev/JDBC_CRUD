plugins {
    id("java")
    kotlin("jvm")
}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4") // Зависимость Jackson для сериализации
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}