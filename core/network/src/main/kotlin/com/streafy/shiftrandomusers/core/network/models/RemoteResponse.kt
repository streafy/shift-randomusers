package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.Serializable

@Serializable
data class RemoteResponse(
    val results: List<UserDto>,
    val info: InfoDto
)