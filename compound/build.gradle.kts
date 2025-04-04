import com.vanniktech.maven.publish.SonatypeHost

/*
 * Copyright 2022, 2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kover)
    alias(libs.plugins.roborazzi)
    alias(libs.plugins.dependencycheck)
}

android {
    namespace = "io.element.android.compound"

    defaultConfig {
        compileSdk = 35
        minSdk = 23

        vectorDrawables {
            useSupportLibrary = true
            generatedDensities()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
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

    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }

    dependencies {
        implementation(libs.androidx.activity.activity)
        implementation(libs.androidx.compose.material3)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.ui.tooling.preview.android)
        implementation(libs.kotlinx.collections)

        // Showkase
        implementation(libs.showkase)
        ksp(libs.showkase.processor)
        kspTest(libs.showkase.processor)

        // Tests
        testImplementation(libs.test.junit)
        testImplementation(libs.androidx.compose.ui.test.junit)
        testImplementation(libs.test.robolectric)
        testImplementation(libs.test.roborazzi)
        testImplementation(libs.test.roborazzi.compose)
        testImplementation(libs.test.roborazzi.junit)
        testImplementation(libs.test.espresso.core)
    }
}

kotlin {
    jvmToolchain(21)
}

configure<org.owasp.dependencycheck.gradle.extension.DependencyCheckExtension> {
    (properties["NVD_API_KEY"] as? String)?.let { nvd.apiKey = it }
    nvd.delay = 1600
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()

    coordinates("io.element.android", "compound-android", "25.4.4")
    if (!providers.gradleProperty("mavenCentralUsername").isPresent) {
        println("No maven central provider")
    }
    pom {
        name = "Compound Android"
        description.set("Compound Tokens in a format Android projects can use.")
        inceptionYear.set("2023")
        url.set("https://github.com/element-hq/compound-android/")
        licenses {
            license {
                name.set("GNU Affero General Public License (AGPL) version 3.0")
                url.set("https://www.gnu.org/licenses/agpl-3.0.txt")
                distribution.set("https://www.gnu.org/licenses/agpl-3.0.txt")
            }
            license {
                name.set("Element Commercial License")
                url.set("https://raw.githubusercontent.com/element-hq/compound-android/refs/heads/main/LICENSE-COMMERCIAL")
                distribution.set("https://raw.githubusercontent.com/element-hq/compound-android/refs/heads/main/LICENSE-COMMERCIAL")
            }
        }
        developers {
            developer {
                id.set("matrixdev")
                name.set("matrixdev")
                url.set("https://github.com/element-hq/")
                email.set("android@element.io")
            }
        }
        scm {
            url.set("https://github.com/username/mylibrary/")
            connection.set("scm:git:git://github.com/element-hq/compound-android.git")
            developerConnection.set("scm:git:ssh://git@github.com/element-hq/compound-android.git")
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
                "*ComposableSingletons*",
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
                    minValue = 80
                    metric = kotlinx.kover.gradle.plugin.dsl.MetricType.INSTRUCTION
                    aggregation = kotlinx.kover.gradle.plugin.dsl.AggregationType.COVERED_PERCENTAGE
                }
            }
        }
    }
}

val snapshotsDir = File("${projectDir}/screenshots")
val removeOldScreenshotsTask = tasks.register("removeOldSnapshots") {
    onlyIf { snapshotsDir.exists() }
    doFirst {
        println("Delete previous screenshots located at $snapshotsDir\n")
        snapshotsDir.deleteRecursively()
    }
}
afterEvaluate {
    tasks.findByName("recordRoborazzi")?.dependsOn(removeOldScreenshotsTask)
    tasks.findByName("recordRoborazziDebug")?.dependsOn(removeOldScreenshotsTask)
    tasks.findByName("recordRoborazziRelease")?.dependsOn(removeOldScreenshotsTask)
}