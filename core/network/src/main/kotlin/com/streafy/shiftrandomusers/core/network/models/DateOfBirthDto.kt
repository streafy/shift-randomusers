package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class DateOfBirthDto(
    val date: String,
    val age: Int
)