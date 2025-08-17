package com.streafy.shiftrandomusers.navigation

import kotlinx.serialization.Serializable

interface Route

@Serializable
data object UserListRoute : Route

@Serializable
data class UserDetailsRoute(val userId: String) : Route