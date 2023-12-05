plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "TestKotlin"
include("models")
include("serialization")
include("generator")
include("deserialization")
include("connectDB")
include("consoleApp")
