package com.streafy.shiftrandomusers.di

import com.streafy.shiftrandomusers.BuildConfig
import com.streafy.shiftrandomusers.core.network.RandomUserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRandomUserApi(): RandomUserApi =
        RandomUserApi(baseUrl = BuildConfig.RANDOMUSER_API_BASE_URL)
}