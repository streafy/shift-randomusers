package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PictureDto(
    val large: String,
    val medium: String,
    val thumbnail: String,
)