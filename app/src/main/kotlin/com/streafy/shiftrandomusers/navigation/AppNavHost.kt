package com.streafy.shiftrandomusers.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

    NavHost(
        navController = navController,
        startDestination = UserListRoute
    ) {
        composable<UserListRoute> { UserListScreen() }
        composable<UserDetailsRoute> { UserDetailsScreen() }
    }
}