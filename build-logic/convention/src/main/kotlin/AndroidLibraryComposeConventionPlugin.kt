import com.android.build.gradle.LibraryExtension
import com.streafy.shiftrandomusers.buildlogic.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "shiftrandomusers.android.library")

            extensions.configure<LibraryExtension> {
                configureCompose(this)
            }
        }
    }
}