plugins {
    alias(libs.plugins.shiftrandomusers.android.library.compose)
}

android {
    namespace = "com.streafy.shiftrandomusers.feature.userlist"
}

dependencies {
    implementation(project(":core:ui"))

    implementation(libs.lifecycle.viewmodel.compose)

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
}