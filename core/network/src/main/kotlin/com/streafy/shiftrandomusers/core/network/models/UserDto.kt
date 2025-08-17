package com.streafy.shiftrandomusers.core.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val gender: String,
    val name: NameDto,
    val location: LocationDto,
    val email: String,
    val login: LoginDto,
    @SerialName("dob") val dateOfBirth: DateOfBirthDto,
    val registered: RegisteredDto,
    val phone: String,
    val cell: String,
    val picture: PictureDto,
    @SerialName("nat") val nationality: String,
)

