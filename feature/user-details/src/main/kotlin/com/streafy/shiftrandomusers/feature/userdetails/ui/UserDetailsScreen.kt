package com.streafy.shiftrandomusers.feature.userdetails.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.streafy.shiftrandomusers.core.ui.components.AppTopBarWithBackButton
import com.streafy.shiftrandomusers.core.ui.components.FullScreenProgressIndicator
import com.streafy.shiftrandomusers.feature.userdetails.R
import com.streafy.shiftrandomusers.feature.userdetails.presentation.UserDetailsUiState
import com.streafy.shiftrandomusers.feature.userdetails.presentation.UserDetailsViewModel

@Composable
fun UserDetailsScreen(
    viewModel: UserDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadUserDetails()
    }

    UserDetailsScreen(
        state = state.value,
        onBack = viewModel::back,
        onRetry = viewModel::loadUserDetails
    )
}

@Composable
private fun UserDetailsScreen(
    state: UserDetailsUiState,
    onBack: () -> Unit,
    onRetry: () -> Unit
) {
    Scaffold(
        topBar = {
            AppTopBarWithBackButton(
                titleText = stringResource(R.string.user_details_screen_title),
                onNavigateBack = onBack
            )
        }
    ) { contentPadding ->
        when (state) {
            is UserDetailsUiState.Content -> UserDetailsCard(
                userDetails = state.userDetails,
                modifier = Modifier.padding(contentPadding)
            )

            is UserDetailsUiState.Error -> ErrorContent(
                onBack = onBack,
                onRetry = onRetry,
                errorMessage = state.message
            )

            UserDetailsUiState.Initial,
            UserDetailsUiState.Loading -> FullScreenProgressIndicator(
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}

