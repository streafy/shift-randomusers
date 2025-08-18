package com.streafy.shiftrandomusers.feature.userdetails.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.streafy.shiftrandomusers.core.ui.components.ErrorDialog
import com.streafy.shiftrandomusers.feature.userdetails.R

/**
 * Wrapper around ErrorDialog. Used to hide ErrorDialog instantly when navigating back.
 */
@Composable
fun ErrorContent(
    onBack: () -> Unit,
    onRetry: () -> Unit,
    errorMessage: String
) {
    val showErrorDialog = remember { mutableStateOf(true) }

    if (showErrorDialog.value) {
        ErrorDialog(
            onDismissRequest = {
                showErrorDialog.value = false
                onBack()
            },
            onConfirm = onRetry,
            errorMessage = errorMessage,
            confirmText = stringResource(R.string.error_content_retry),
            dismissText = stringResource(R.string.error_content_back)
        )
    }
}