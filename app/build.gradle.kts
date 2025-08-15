plugins {
    alias(libs.plugins.shiftrandomusers.android.application)
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
}