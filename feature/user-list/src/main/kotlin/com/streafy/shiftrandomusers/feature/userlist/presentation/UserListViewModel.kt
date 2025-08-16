package com.streafy.shiftrandomusers.feature.userlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.shiftrandomusers.feature.userlist.domain.User
import com.streafy.shiftrandomusers.feature.userlist.domain.usecases.GetUsersUseCase
import com.streafy.shiftrandomusers.feature.userlist.domain.usecases.UpdateUsersUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewModel(
    private val getUsersUseCase: GetUsersUseCase,
    private val updateUsersUseCase: UpdateUsersUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<UserListUiState> =
        MutableStateFlow(UserListUiState.Initial)
    val state = _state.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, exception ->
        _state.value = when (val stateValue = _state.value) {
            is UserListUiState.Content -> stateValue.copy(
                updating = false,
                errorMessage = exception.message
            )

            else -> UserListUiState.Content(
                users = emptyList(),
                updating = false,
                errorMessage = exception.message
            )
        }
    }

    fun loadUsers() {
        if (_state.value is UserListUiState.Loading || _state.value is UserListUiState.Content) {
            return
        }

        _state.value = UserListUiState.Loading
        viewModelScope.launch(handler) {
            val users = getUsersUseCase()
            _state.value = UserListUiState.Content(
                users = users,
                updating = false,
                errorMessage = null
            )
        }
    }

    fun updateUsers() {
        val stateValue = _state.value
        if (stateValue !is UserListUiState.Content) {
            return
        }

        viewModelScope.launch(handler) {
            _state.value = stateValue.copy(updating = true)
            updateUsersUseCase()

            val users = getUsersUseCase()
            _state.value =
                UserListUiState.Content(
                    users = users,
                    updating = false,
                    errorMessage = null
                )
        }
    }

    fun clearError() {
        val stateValue = _state.value
        if (stateValue !is UserListUiState.Content) {
            return
        }

        _state.value = stateValue.copy(errorMessage = null)
    }
}

sealed interface UserListUiState {
    object Initial : UserListUiState
    object Loading : UserListUiState
    data class Content(
        val users: List<User>,
        val updating: Boolean,
        val errorMessage: String?
    ) : UserListUiState
}