package com.streafy.shiftrandomusers.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class NavComponentGlobalRouter @Inject constructor() : GlobalRouter {
    private var navController: NavController? = null
    private val commands = mutableListOf<(NavController) -> Unit>()

    override fun open(route: Route) = execute { navController ->
        navController.navigate(route)
    }

    override fun openAsRoot(route: Route) = execute { navController ->
        navController.navigate(route) {
            popUpTo(0)
        }
    }

    override fun back() = execute { navController ->
        navController.navigateUp()
    }

    fun setNavController(navController: NavController) {
        this.navController = navController
        commands.toList().forEach { command -> command.invoke(navController) }
        commands.clear()
    }

    fun clearNavController() {
        this.navController = null
    }

    private fun execute(command: (NavController) -> Unit) {
        val navController = this.navController
        if (navController != null) {
            command.invoke(navController)
        } else {
            commands.add(command)
        }
    }

    @HiltViewModel
    class VM @Inject constructor(
        val globalRouter: NavComponentGlobalRouter
    ): ViewModel()

    companion object {
        @Composable
        fun get(): NavComponentGlobalRouter {
            return hiltViewModel<VM>().globalRouter
        }
    }
}