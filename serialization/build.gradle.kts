dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4") // Зависимость Jackson для сериализации
    implementation(project(":models")) // Зависимость от модуля "models"
    implementation(project(":generator")) // Зависимость от модуля "generator"
}

tasks.register<JavaExec>("recreateDataBase") {
    mainClass.set("org.example.Main")
    classpath = sourceSets["main"].runtimeClasspath
    workingDir = rootProject.projectDir
}


tasks.test {
    useJUnitPlatform()
}