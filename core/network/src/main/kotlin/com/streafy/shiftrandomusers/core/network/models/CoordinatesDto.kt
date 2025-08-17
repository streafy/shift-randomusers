package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesDto(
    val latitude: String,
    val longitude: String
)
