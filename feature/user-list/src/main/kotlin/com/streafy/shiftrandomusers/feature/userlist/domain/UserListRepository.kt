package com.streafy.shiftrandomusers.feature.userlist.domain

interface UserListRepository {
    suspend fun getUsers(): List<User>

    suspend fun updateUsers()
}