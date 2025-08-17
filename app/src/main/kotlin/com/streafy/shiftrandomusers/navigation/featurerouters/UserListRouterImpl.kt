package com.streafy.shiftrandomusers.navigation.featurerouters

import com.streafy.shiftrandomusers.feature.userlist.presentation.UserListRouter
import com.streafy.shiftrandomusers.navigation.GlobalRouter
import com.streafy.shiftrandomusers.navigation.UserDetailsRoute
import javax.inject.Inject

class UserListRouterImpl @Inject constructor(
    private val router: GlobalRouter
) : UserListRouter {
    override fun openUserDetails(userId: String) {
        router.open(UserDetailsRoute(userId))
    }
}