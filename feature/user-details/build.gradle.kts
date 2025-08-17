plugins {
    alias(libs.plugins.shiftrandomusers.android.library.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.streafy.shiftrandomusers.feature.userdetails"
}

dependencies {
    implementation(project(":core:ui"))

    implementation(libs.lifecycle.viewmodel.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}