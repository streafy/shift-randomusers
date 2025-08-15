package com.streafy.shiftrandomusers.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    extensions.configure<KotlinAndroidProjectExtension> {
        jvmToolchain(11)
    }

    commonExtension.apply {
        compileSdk = 36

        defaultConfig {
            minSdk = 26
        }
    }
}