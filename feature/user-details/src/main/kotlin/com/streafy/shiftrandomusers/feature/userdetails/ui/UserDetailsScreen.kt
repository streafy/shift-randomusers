package com.streafy.shiftrandomusers.feature.userdetails.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.streafy.shiftrandomusers.core.ui.components.AppTopBarWithBackButton
import com.streafy.shiftrandomusers.feature.userdetails.R
import com.streafy.shiftrandomusers.feature.userdetails.presentation.UserDetailsViewModel

@Composable
fun UserDetailsScreen(
    viewModel: UserDetailsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            AppTopBarWithBackButton(
                titleText = stringResource(R.string.user_details_screen_title),
                onNavigateBack = viewModel::back
            )
        }
    ) { contentPadding ->
        Text(
            text = "user details",
            modifier = Modifier.padding(contentPadding)
        )
    }
}