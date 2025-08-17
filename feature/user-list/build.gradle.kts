plugins {
    alias(libs.plugins.shiftrandomusers.android.library.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.streafy.shiftrandomusers.feature.userlist"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))

    implementation(libs.lifecycle.viewmodel.compose)

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}