package com.streafy.shiftrandomusers.di

import android.content.Context
import com.streafy.shiftrandomusers.core.database.UserDao
import com.streafy.shiftrandomusers.core.database.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUsersDatabase(@ApplicationContext context: Context): UsersDatabase =
        UsersDatabase(context)

    @Provides
    @Singleton
    fun provideUserDao(database: UsersDatabase): UserDao =
        database.userDao()
}