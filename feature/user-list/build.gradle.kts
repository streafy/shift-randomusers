plugins {
    alias(libs.plugins.shiftrandomusers.android.feature)
}

android {
    namespace = "com.streafy.shiftrandomusers.feature.userlist"
}

dependencies {
    implementation(project(":core:network"))
}