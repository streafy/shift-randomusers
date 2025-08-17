package com.streafy.shiftrandomusers.di

import com.streafy.shiftrandomusers.navigation.GlobalRouter
import com.streafy.shiftrandomusers.navigation.NavComponentGlobalRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface GlobalRouterModule {
    @Binds
    fun bindGlobalRouter(impl: NavComponentGlobalRouter): GlobalRouter
}