package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class NameDto(
    val title: String,
    val first: String,
    val last: String
)