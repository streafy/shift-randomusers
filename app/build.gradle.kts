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

        buildConfigField("String", "RANDOMUSER_API_BASE_URL", "\"https://randomuser.me/\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":feature:user-list"))

    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))

    implementation(libs.activity.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.room.ktx)
}