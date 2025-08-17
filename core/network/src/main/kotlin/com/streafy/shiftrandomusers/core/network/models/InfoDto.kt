package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)