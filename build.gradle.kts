
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false

}
buildscript {
    repositories {
        mavenCentral()

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.2")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.50")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
        // NOTE: Do not place your application dependencies here they belong
        // in the individual module build.gradle files
    }
}