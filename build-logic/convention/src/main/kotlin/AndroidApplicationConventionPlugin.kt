import com.android.build.api.dsl.ApplicationExtension
import com.streafy.shiftrandomusers.buildlogic.configureCompose
import com.streafy.shiftrandomusers.buildlogic.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.application")
            apply(plugin = "org.jetbrains.kotlin.android")

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = 36

                configureCompose(this)
                configureKotlinAndroid(this)
            }
        }
    }
}