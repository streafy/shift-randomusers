package com.streafy.shiftrandomusers.feature.userdetails.domain

interface UserDetailsRepository {
    suspend fun getUserDetails(userId: String): UserDetails
}