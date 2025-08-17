package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class TimezoneDto(
    val offset: String,
    val description: String
)
