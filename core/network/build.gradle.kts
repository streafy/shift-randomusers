plugins {
    alias(libs.plugins.shiftrandomusers.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.streafy.shiftrandomusers.core.network"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
}