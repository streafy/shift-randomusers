package com.streafy.shiftrandomusers.di

import com.streafy.shiftrandomusers.feature.userdetails.presentation.UserDetailsRouter
import com.streafy.shiftrandomusers.feature.userlist.presentation.UserListRouter
import com.streafy.shiftrandomusers.navigation.featurerouters.UserDetailsRouterImpl
import com.streafy.shiftrandomusers.navigation.featurerouters.UserListRouterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FeatureRoutersModule {
    @Binds
    fun bindUserListRouter(impl: UserListRouterImpl): UserListRouter

    @Binds
    fun bindUserDetailsRouter(impl: UserDetailsRouterImpl): UserDetailsRouter
}