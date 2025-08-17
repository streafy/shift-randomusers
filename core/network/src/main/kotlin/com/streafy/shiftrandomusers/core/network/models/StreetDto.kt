package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class StreetDto(
    val number: Int,
    val name: String
)