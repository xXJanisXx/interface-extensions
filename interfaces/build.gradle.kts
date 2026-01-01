plugins {
    id("java-library")
    id("maven-publish")
}

dependencies {
    compileOnly(libs.paper.api)
    implementation(libs.interfaces)
}

java {
    withJavadocJar()
    withSourcesJar()
}


publishing {
    repositories {
        maven {
            name = "maven-repository"
            url = uri("https://repo.xxjanisxx.dev/releases")
            credentials {
                username = project.findProperty("mavenRepositoryUser") as String
                password = project.findProperty("mavenRepositoryPassword") as String
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                name = "interface-extensions"
                description = "Some extensions for the Interfaces Kotlin library."
                url = "https://github.com/xXJanisXx/interface-extensions"
                scm {
                    url = "https://github.com/xXJanisXx/interface-extensions"
                    connection = "scm:git:https://github.com/xXJanisXx/interface-extensions.git"
                    developerConnection = "scm:git:https://github.com/xXJanisXx/interface-extensions.git"
                }
                licenses {
                    license {
                        name = "Apache-2.0"
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                    }
                }
                developers {
                    developer {
                        id = "xxjanisxx"
                        name = "Janis K."
                        email = "xxjanisxx@proton.me"
                    }
                }
            }
        }
    }
}