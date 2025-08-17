package com.streafy.shiftrandomusers.navigation.featurerouters

import com.streafy.shiftrandomusers.feature.userdetails.presentation.UserDetailsRouter
import com.streafy.shiftrandomusers.navigation.GlobalRouter
import javax.inject.Inject

class UserDetailsRouterImpl @Inject constructor(
    private val router: GlobalRouter
) : UserDetailsRouter {
    override fun back() {
        router.back()
    }
}