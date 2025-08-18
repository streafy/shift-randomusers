package com.streafy.shiftrandomusers.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.streafy.shiftrandomusers.core.ui.R

@Composable
fun RetryButtonBox(onRetry: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onRetry) {
            Text(stringResource(R.string.retry_button_box_retry_button_text))
        }
    }
}
