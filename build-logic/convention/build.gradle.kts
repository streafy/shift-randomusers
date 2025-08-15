plugins {
    `kotlin-dsl`
}

group = "com.streafy.shiftrandomusers.buildlogic"

kotlin {
    jvmToolchain(11)
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.shiftrandomusers.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}