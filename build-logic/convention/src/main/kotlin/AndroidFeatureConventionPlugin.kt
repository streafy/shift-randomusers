import com.streafy.shiftrandomusers.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "shiftrandomusers.android.library.compose")
            apply(plugin = "com.google.devtools.ksp")
            apply(plugin = "com.google.dagger.hilt.android")

            dependencies {
                "implementation"(project(":core:ui"))
                "implementation"(project(":core:database"))

                "implementation"(libs.findLibrary("lifecycle.viewmodel.compose").get())

                "implementation"(libs.findLibrary("hilt.android").get())
                "ksp"(libs.findLibrary("hilt.compiler").get())
                "implementation"(libs.findLibrary("hilt.navigation.compose").get())

                "implementation"(libs.findLibrary("coil.compose").get())
                "implementation"(libs.findLibrary("coil.network.okhttp").get())
            }
        }
    }
}