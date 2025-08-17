package com.streafy.shiftrandomusers.di

import com.streafy.shiftrandomusers.feature.userlist.data.UserListRepositoryImpl
import com.streafy.shiftrandomusers.feature.userlist.domain.UserListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UserListModule {
    @Binds
    @Singleton
    fun bindUserListRepository(impl: UserListRepositoryImpl): UserListRepository
}