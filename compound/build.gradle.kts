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
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.ksp)
    alias(libs.plugins.paparazzi)
    alias(libs.plugins.kover)
}

android {
    namespace = "io.element.android.compound"

    defaultConfig {
        compileSdk = 34
        minSdk = 23

        vectorDrawables {
            useSupportLibrary = true
            generatedDensities()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
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

    dependencies {
        implementation(libs.androidx.compose.material3)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.ui.tooling.preview.android)
        implementation(libs.kotlinx.collections)

        implementation(libs.showkase)
        ksp(libs.showkase.processor)
        kspTest(libs.showkase.processor)

        implementation(libs.accompanist.systemui)

        testImplementation(libs.test.junit)
        testImplementation(libs.test.parameter.injector)
        // Paparazzi 1.3.2 workaround (see https://github.com/cashapp/paparazzi/blob/master/CHANGELOG.md#132---2024-01-13)
        constraints.add("testImplementation", "com.google.guava:guava") {
            attributes {
                attribute(
                    TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
                    objects.named(TargetJvmEnvironment::class.java, TargetJvmEnvironment.STANDARD_JVM)
                )
            }
            because(
                "LayoutLib and sdk-common depend on Guava's -jre published variant." +
                        "See https://github.com/cashapp/paparazzi/issues/906."
            )
        }
    }
}

kotlin {
    jvmToolchain(17)
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()

    coordinates("io.element.android", "compound-android", "0.0.5-SNAPSHOT")
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

// Workaround: `kover` tasks somehow trigger the screenshot tests with a broken configuration, removing
// any previous test results and not creating new ones. This is a workaround to disable the screenshot tests
// when the `kover` tasks are detected.
tasks.withType<Test> {
    if (project.gradle.startParameter.taskNames.any { it.contains("kover", ignoreCase = true) }) {
        println("WARNING: Kover task detected, disabling screenshot test task $name.")
        isEnabled = false
    }
}

// https://kotlin.github.io/kotlinx-kover/
// Run `./gradlew :app:koverHtmlReport` to get report at ./app/build/reports/kover
// Run `./gradlew :app:koverXmlReport` to get XML report
koverReport {
    filters {
        excludes {
            classes(
                // Exclude generated classes.
                "com.airbnb.android.showkase*",
                "io.element.android.compound.showkase*",
                "*BuildConfig",
                // Generated by Showkase.
                // These should be annotated with some `*Generated` annotation), but until them we need to filter them out manually.
                "*Ioelementandroid*PreviewKt$*",
                "*Ioelementandroid*PreviewKt",
                "io.element.android.compound.previews.IconsCompoundPreviewDarkDefaultGroupIconsCompoundPreviewDarkKt*",
                "io.element.android.compound.previews.IconsCompoundPreviewLightDefaultGroupIconsCompoundPreviewLightKt*",
                "io.element.android.compound.tokens.CompoundBodyLgMediumCompoundM3TitleMediumKt",
                "io.element.android.compound.tokens.CompoundBodyLgRegularCompoundM3BodyLargeKt",
                "io.element.android.compound.tokens.CompoundBodyMdMediumCompoundM3TitleSmallKt",
                "io.element.android.compound.tokens.CompoundBodyMdMediumLabelLargeCompoundM3LabelLargeKt",
                "io.element.android.compound.tokens.CompoundBodyMdRegularCompoundM3BodyMediumKt",
                "io.element.android.compound.tokens.CompoundBodySmMediumCompoundM3LabelMediumKt",
                "io.element.android.compound.tokens.CompoundBodySmRegularCompoundM3BodySmallKt",
                "io.element.android.compound.tokens.CompoundBodyXsMediumCompoundM3LabelSmallKt",
                "io.element.android.compound.tokens.CompoundHeadingLgRegularCompoundM3HeadlineMediumKt",
                "io.element.android.compound.tokens.CompoundHeadingMdRegularCompoundM3TitleLargeKt",
                "io.element.android.compound.tokens.CompoundHeadingXlRegularCompoundM3HeadlineLargeKt",
                "io.element.android.compound.tokens.DefaultHeadlineSmallCompoundM3HeadlineSmallKt",
                "io.element.android.compound.theme.AvatarColorsDarkPreviewDefaultGroupAvatarColorsDarkPreviewKt",
                "io.element.android.compound.theme.AvatarColorsLightPreviewDefaultGroupAvatarColorsLightPreviewKt",
                "io.element.android.compound.theme.ColorsSchemeDarkPreviewDefaultGroupColorsSchemeDarkPreviewKt",
                "io.element.android.compound.theme.ColorsSchemeLightPreviewDefaultGroupColorsSchemeLightPreviewKt",
                "io.element.android.compound.theme.ComposableSingletons*",
            )
            annotatedBy(
                "androidx.compose.ui.tooling.preview.Preview",
            )
        }
    }

    defaults {
        // add reports of both 'debug' and 'release' Android build variants to default reports
        mergeWith("debug")

        verify {
            onCheck = true
            // General rule: minimum code coverage.
            rule("Global minimum code coverage.") {
                isEnabled = true
                entity = kotlinx.kover.gradle.plugin.dsl.GroupingEntityType.APPLICATION
                bound {
                    minValue = 65
                    // Setting a max value, so that if coverage is bigger, it means that we have to change minValue.
                    // For instance if we have minValue = 20 and maxValue = 30, and current code coverage is now 31.32%, update
                    // minValue to 25 and maxValue to 35.
                    maxValue = 75
                    metric = kotlinx.kover.gradle.plugin.dsl.MetricType.INSTRUCTION
                    aggregation = kotlinx.kover.gradle.plugin.dsl.AggregationType.COVERED_PERCENTAGE
                }
            }
        }
    }
}

val snapshotsDir = File("${projectDir}/src/test/snapshots")
val removeOldScreenshotsTask = tasks.register("removeOldSnapshots") {
    onlyIf { snapshotsDir.exists() }
    doFirst {
        println("Delete previous screenshots located at $snapshotsDir\n")
        snapshotsDir.deleteRecursively()
    }
}
afterEvaluate {
    tasks.findByName("recordPaparazzi")?.dependsOn(removeOldScreenshotsTask)
    tasks.findByName("recordPaparazziDebug")?.dependsOn(removeOldScreenshotsTask)
    tasks.findByName("recordPaparazziRelease")?.dependsOn(removeOldScreenshotsTask)
}