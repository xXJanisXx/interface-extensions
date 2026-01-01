plugins {
    id("java-library")
}

dependencies {
    compileOnly(libs.paper.api)
    implementation(libs.interfaces)
}

java {
    withJavadocJar()
    withSourcesJar()
}