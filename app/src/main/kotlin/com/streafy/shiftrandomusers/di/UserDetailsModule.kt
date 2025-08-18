package com.streafy.shiftrandomusers.di

import com.streafy.shiftrandomusers.feature.userdetails.data.UserDetailsRepositoryImpl
import com.streafy.shiftrandomusers.feature.userdetails.domain.UserDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UserDetailsModule {
    @Binds
    @Singleton
    fun bindUserDetailsRepository(impl: UserDetailsRepositoryImpl): UserDetailsRepository
}