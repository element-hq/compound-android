import com.vanniktech.maven.publish.SonatypeHost

/*
 * Copyright (c) 2022 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "io.element.android.compound"

    defaultConfig {
        compileSdk = 34
        minSdk = 23
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
    }

    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }

    sourceSets {
        named("main") {
            kotlin.srcDir(project.buildDir.resolve("generated/icons/main/kotlin"))
        }
    }

    dependencies {
        implementation(libs.androidx.compose.material3)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.ui.tooling.preview.android)
        implementation(libs.kotlinx.collections)

        implementation(libs.showkase)
        ksp(libs.showkase.processor)
        kspTest(libs.showkase.processor)

        implementation(libs.accompanist.systemui)
    }
}

kotlin {
    jvmToolchain(17)
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()

    coordinates("io.element.android", "compound-android", "0.0.1")
    if (!providers.gradleProperty("mavenCentralUsername").isPresent) {
        println("No maven central provider")
    }
    pom {
        name = "Compound Android"
        description.set("Compound Tokens in a format Android projects can use.")
        inceptionYear.set("2023")
        url.set("https://github.com/vector-im/compound-android/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("matrixdev")
                name.set("matrixdev")
                url.set("https://github.com/vector-im/")
                email.set("android@element.io")
            }
        }
        scm {
            url.set("https://github.com/username/mylibrary/")
            connection.set("scm:git:git://github.com/username/mylibrary.git")
            developerConnection.set("scm:git:ssh://git@github.com/username/mylibrary.git")
        }
    }
}
