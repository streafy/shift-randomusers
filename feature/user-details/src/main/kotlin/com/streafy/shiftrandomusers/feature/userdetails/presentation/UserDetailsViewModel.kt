package com.streafy.shiftrandomusers.feature.userdetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.shiftrandomusers.feature.userdetails.domain.GetUserDetailsUseCase
import com.streafy.shiftrandomusers.feature.userdetails.domain.UserDetails
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = UserDetailsViewModel.Factory::class)
class UserDetailsViewModel @AssistedInject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val router: UserDetailsRouter,
    @Assisted val userId: String
) : ViewModel() {
    private val _state: MutableStateFlow<UserDetailsUiState> =
        MutableStateFlow(UserDetailsUiState.Initial)
    val state = _state.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value = UserDetailsUiState.Error(message = exception.message.orEmpty())
    }

    fun loadUserDetails() {
        if (_state.value is UserDetailsUiState.Loading || _state.value is UserDetailsUiState.Content) {
            return
        }

        _state.value = UserDetailsUiState.Loading
        viewModelScope.launch(handler) {
            val userDetails = getUserDetailsUseCase(userId)
            _state.value =  UserDetailsUiState.Content(userDetails)
        }
    }

    fun back() {
        router.back()
    }

    @AssistedFactory
    interface Factory {
        fun create(id: String): UserDetailsViewModel
    }
}

sealed interface UserDetailsUiState {
    object Initial : UserDetailsUiState

    object Loading : UserDetailsUiState

    data class Content(
        val userDetails: UserDetails,
    ) : UserDetailsUiState

    data class Error(
        val message: String
    ) : UserDetailsUiState
}