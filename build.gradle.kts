// Tệp build.gradle.kts của project-level
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

// Tệp build.gradle.kts của project-level
buildscript {
    repositories {
        google() // Thêm repository Google
        mavenCentral() // Thêm repository Maven Central
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.4.0")  // Hoặc phiên bản phù hợp của Android Gradle Plugin
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")  // Thêm classpath cho plugin Kotlin
        classpath("com.google.gms:google-services:4.4.2")
    }
}
