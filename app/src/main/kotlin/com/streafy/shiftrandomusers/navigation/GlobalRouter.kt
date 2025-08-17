package com.streafy.shiftrandomusers.navigation

interface GlobalRouter {
    fun open(route: Route)

    fun openAsRoot(route: Route)

    fun back()
}