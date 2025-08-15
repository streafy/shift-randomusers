package com.streafy.shiftrandomusers.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        apply(plugin = "org.jetbrains.kotlin.plugin.compose")

        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("compose-bom").get()
            "implementation"(platform(bom))

            // Android Studio Preview support
            "implementation"(libs.findLibrary("ui-tooling-preview").get())
            "debugImplementation"(libs.findLibrary("ui-tooling").get())

            // Material Design 3
            "implementation"(libs.findLibrary("material3").get())
        }
    }
}