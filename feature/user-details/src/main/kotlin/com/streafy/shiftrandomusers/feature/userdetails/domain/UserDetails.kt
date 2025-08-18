package com.streafy.shiftrandomusers.feature.userdetails.domain

data class UserDetails(
    val id: String,
    val firstName: String,
    val lastName: String,
    val photoUrl: String,
    val phone: String,
    val email: String,
    val streetNumber: Int,
    val streetName: String,
    val city: String,
    val state: String,
    val country: String,
    val latitude: String,
    val longitude: String,
    val username: String,
    val dateOfBirthDate: String,
    val dateOfBirthAge: Int,
    val registeredDate: String,
    val registeredAge: Int,
    val nationality: String
)
