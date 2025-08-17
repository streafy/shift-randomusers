package com.streafy.shiftrandomusers.feature.userlist.data

import com.streafy.shiftrandomusers.core.database.UserDao
import com.streafy.shiftrandomusers.core.network.RandomUserApi
import com.streafy.shiftrandomusers.feature.userlist.domain.User
import com.streafy.shiftrandomusers.feature.userlist.domain.UserListRepository
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(
    private val api: RandomUserApi,
    private val userDao: UserDao
) : UserListRepository {
    override suspend fun getUsers(): List<User> {
        val localUsers = userDao.getUsers()

        if (localUsers.isNotEmpty()) {
            return localUsers.map { it.toDomainModel() }
        }

        val remoteUsers = api.getUsers(20).results
        userDao.insertAll(remoteUsers.map { it.toDatabaseEntity() })

        return userDao.getUsers().map { it.toDomainModel() }
    }

    override suspend fun updateUsers() {
        TODO("Not yet implemented")
    }
}