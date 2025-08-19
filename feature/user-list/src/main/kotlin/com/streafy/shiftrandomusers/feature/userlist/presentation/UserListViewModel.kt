package com.streafy.shiftrandomusers.feature.userlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.shiftrandomusers.feature.userlist.domain.User
import com.streafy.shiftrandomusers.feature.userlist.domain.usecases.GetUsersUseCase
import com.streafy.shiftrandomusers.feature.userlist.domain.usecases.UpdateUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val updateUsersUseCase: UpdateUsersUseCase,
    private val router: UserListRouter
) : ViewModel() {
    private val _state: MutableStateFlow<UserListUiState> =
        MutableStateFlow(UserListUiState.Empty)
    val state = _state.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value = UserListUiState.Error(
            users = _state.value.users ?: emptyList(),
            errorMessage = exception.message.orEmpty()
        )
    }

    fun loadUsers() {
        if (_state.value !is UserListUiState.Empty) {
            return
        }

        _state.value = UserListUiState.Loading
        viewModelScope.launch(handler) {
            val users = getUsersUseCase()
            _state.value = UserListUiState.Content(users = users)
        }
    }

    fun updateUsers() {
        val stateValue = _state.value
        if (stateValue !is UserListUiState.Content) {
            return
        }

        _state.value = UserListUiState.Updating(stateValue.users)
        viewModelScope.launch(handler) {
            updateUsersUseCase()

            val users = getUsersUseCase()
            _state.value = UserListUiState.Content(users)
        }
    }

    fun dismissError() {
        val stateValue = _state.value
        if (stateValue !is UserListUiState.Error) {
            return
        }

        if (stateValue.users.isEmpty()) {
            _state.value = UserListUiState.Empty
        } else {
            _state.value = UserListUiState.Content(stateValue.users)
        }
    }

    fun openDetails(userId: String) {
        router.openUserDetails(userId)
    }
}

sealed class UserListUiState(open val users: List<User>?) {
    object Empty : UserListUiState(users = null)

    object Loading : UserListUiState(users = null)

    data class Updating(
        override val users: List<User>
    ) : UserListUiState(users)

    data class Content(
        override val users: List<User>
    ) : UserListUiState(users)

    data class Error(
        override val users: List<User>,
        val errorMessage: String
    ) : UserListUiState(users)
}