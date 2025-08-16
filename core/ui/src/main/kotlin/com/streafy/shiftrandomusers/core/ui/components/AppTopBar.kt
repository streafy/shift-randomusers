package com.streafy.shiftrandomusers.core.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    titleText: String,
) {
    TopAppBar(
        title = {
            Text(
                text = titleText,
                style = MaterialTheme.typography.displaySmall,
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarWithBackButton(
    titleText: String,
    onNavigateBack: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = titleText,
                style = MaterialTheme.typography.displaySmall,
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}