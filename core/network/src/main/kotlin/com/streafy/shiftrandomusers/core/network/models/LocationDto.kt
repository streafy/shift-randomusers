package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val street: StreetDto,
    val city: String,
    val state: String,
    val country: String,
    val coordinates: CoordinatesDto,
    val timezone: TimezoneDto
)