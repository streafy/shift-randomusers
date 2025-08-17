package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class IdDto(
    val name: String,
    val value: String
)
