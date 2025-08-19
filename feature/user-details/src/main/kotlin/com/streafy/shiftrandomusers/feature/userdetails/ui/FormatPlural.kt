package com.streafy.shiftrandomusers.feature.userdetails.ui

import androidx.annotation.PluralsRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import com.streafy.shiftrandomusers.feature.userdetails.R

@Composable
fun formatPlural(
    @PluralsRes pluralsResId: Int,
    count: Int
): String {
    return if (count == 0) {
        stringResource(R.string.empty_string)
    } else {
        pluralStringResource(
            pluralsResId,
            count,
            count
        )
    }
}