plugins {
    alias(libs.plugins.shiftrandomusers.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.streafy.shiftrandomusers.core.database"
}

dependencies {
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
}