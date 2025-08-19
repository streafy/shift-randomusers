package com.streafy.shiftrandomusers.feature.userdetails.ui

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

fun formatDateString(dateString: String): String {
    return Instant.parse(dateString)
        .atZone(ZoneId.systemDefault())
        .format(formatter)
}