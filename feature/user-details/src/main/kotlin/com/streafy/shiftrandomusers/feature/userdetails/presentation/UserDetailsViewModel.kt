package com.streafy.shiftrandomusers.feature.userdetails.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val router: UserDetailsRouter
) : ViewModel() {
    fun back() {
        router.back()
    }
}