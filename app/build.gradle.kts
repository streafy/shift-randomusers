plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    jvmToolchain(11)
}

android {
    namespace = "com.streafy.shiftrandomusers"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.streafy.shiftrandomusers"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
}