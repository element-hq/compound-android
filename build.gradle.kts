// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.sonarqube)
    alias(libs.plugins.dependencycheck)
}

// To run a sonar analysis:
// Run './gradlew sonar -Dsonar.login=<SONAR_LOGIN>'
// The SONAR_LOGIN is stored in passbolt as Token Sonar Cloud Bma
// Sonar result can be found here: https://sonarcloud.io/project/overview?id=element-hq_compound-android
sonar {
    properties {
        property("sonar.projectName", "compound-android")
        property("sonar.projectKey", "compound-android")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.projectVersion", "1.0")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.links.homepage", "https://github.com/element-hq/compound-android/")
        property("sonar.links.ci", "https://github.com/element-hq/compound-android/actions")
        property("sonar.links.scm", "https://github.com/element-hq/compound-android/")
        property("sonar.links.issue", "https://github.com/element-hq/compound-android/issues")
        property("sonar.organization", "element-hq")
        property("sonar.login", if (project.hasProperty("SONAR_LOGIN")) project.property("SONAR_LOGIN")!! else "invalid")

        // exclude source code from analyses separated by a colon (:)
    }
}
