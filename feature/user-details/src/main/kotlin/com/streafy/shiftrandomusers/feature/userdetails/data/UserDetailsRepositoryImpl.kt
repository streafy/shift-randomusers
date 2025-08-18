package com.streafy.shiftrandomusers.feature.userdetails.data

import com.streafy.shiftrandomusers.core.database.UserDao
import com.streafy.shiftrandomusers.feature.userdetails.domain.UserDetails
import com.streafy.shiftrandomusers.feature.userdetails.domain.UserDetailsRepository
import javax.inject.Inject

class UserDetailsRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserDetailsRepository {
    override suspend fun getUserDetails(userId: String): UserDetails {
        return userDao.getUserById(userId).toDomainModel()
    }
}