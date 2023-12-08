plugins {
    id("java")
    kotlin("jvm") version "1.9.20-RC"
    war
}


tasks.register("runLocalModules") {

    dependsOn(":serialization:recreateDataBase",  ":deserialization:recreateDataBase")
}


allprojects {
    apply {
        plugin("java")
    }

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    group = "org.example"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}


dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":models"))
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4") // Зависимость Jackson для сериализации
    implementation(project(":generator")) // Зависимость от модуля "generator"
    implementation(project(":deserialization"))
    implementation(project(":serialization"))
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("org.eclipse.jetty:jetty-server:9.4.44.v20210927")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}