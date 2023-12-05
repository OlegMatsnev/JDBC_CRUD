plugins {
    id("java")
}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":models"))
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4") // Зависимость Jackson для сериализации
}


tasks.register<JavaExec>("recreateDataBase") {
    mainClass.set("org.example.Main")
    classpath = sourceSets["main"].runtimeClasspath
    workingDir = rootProject.projectDir
}

tasks.test {
    useJUnitPlatform()
}
