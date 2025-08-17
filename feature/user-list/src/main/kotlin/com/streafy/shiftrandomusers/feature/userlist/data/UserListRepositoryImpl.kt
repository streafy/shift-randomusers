package com.streafy.shiftrandomusers.feature.userlist.data

import com.streafy.shiftrandomusers.core.network.RandomUserApi
import com.streafy.shiftrandomusers.feature.userlist.domain.User
import com.streafy.shiftrandomusers.feature.userlist.domain.UserListRepository
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(
    private val api: RandomUserApi
) : UserListRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers(20).results.map { it.toDomainModel() }
    }

    override suspend fun updateUsers() {
        TODO("Not yet implemented")
    }
}