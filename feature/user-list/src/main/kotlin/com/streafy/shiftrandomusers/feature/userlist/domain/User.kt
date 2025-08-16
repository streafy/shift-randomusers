package com.streafy.shiftrandomusers.feature.userlist.domain

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val photoUrl: String,
    val address: String,
    val phone: String
)
