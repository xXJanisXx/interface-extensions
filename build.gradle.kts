import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.kotlin)
}

allprojects {
    group = "dev.xxjanisxx.interfaces"
    version = "0.0.5"

    repositories {
        mavenCentral()
        maven("https://maven.noxcrew.com/public")
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

subprojects {
    apply {
        plugin(rootProject.libs.plugins.kotlin.get().pluginId)
    }

    dependencies {
        implementation(rootProject.libs.kotlin.stdlib)
        testImplementation(rootProject.libs.kotlin.test)
        implementation(rootProject.libs.kotlin.coroutines)
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    kotlin {
        jvmToolchain(21)
        compilerOptions {
            apiVersion.set(KotlinVersion.KOTLIN_2_0)
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}