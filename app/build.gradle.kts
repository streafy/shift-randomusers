plugins {
    alias(libs.plugins.shiftrandomusers.android.application)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.streafy.shiftrandomusers"

    defaultConfig {
        applicationId = "com.streafy.shiftrandomusers"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":core:ui"))

    implementation(libs.activity.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}