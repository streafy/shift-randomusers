package com.streafy.shiftrandomusers.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.streafy.shiftrandomusers.feature.userdetails.presentation.UserDetailsViewModel
import com.streafy.shiftrandomusers.feature.userdetails.ui.UserDetailsScreen
import com.streafy.shiftrandomusers.feature.userlist.ui.UserListScreen
import kotlinx.coroutines.awaitCancellation

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    val globalRouter = NavComponentGlobalRouter.get()
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(Unit) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            try {
                globalRouter.setNavController(navController)
                awaitCancellation()
            } finally {
                globalRouter.clearNavController()
            }
        }
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = UserListRoute
    ) {
        composable<UserListRoute> { UserListScreen() }
        composable<UserDetailsRoute> { entry ->
            val id = entry.toRoute<UserDetailsRoute>().userId

            UserDetailsScreen(
                viewModel = hiltViewModel<UserDetailsViewModel, UserDetailsViewModel.Factory>(
                    key = id
                ) { factory ->
                    factory.create(id)
                }
            )
        }
    }
}

@Composable
private fun AnimatedNavHost(
    navController: NavHostController,
    startDestination: Route,
    builder: NavGraphBuilder.() -> Unit
) {
    val durationMillis = 500

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(durationMillis)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(durationMillis)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(durationMillis)
            )
        },
        builder = builder
    )
}