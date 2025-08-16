package com.streafy.shiftrandomusers.feature.userlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.streafy.shiftrandomusers.core.ui.components.AppTopBar
import com.streafy.shiftrandomusers.core.ui.components.ErrorDialog
import com.streafy.shiftrandomusers.core.ui.components.FullScreenProgressIndicator
import com.streafy.shiftrandomusers.core.ui.components.RetryButtonBox
import com.streafy.shiftrandomusers.feature.userlist.R
import com.streafy.shiftrandomusers.feature.userlist.domain.User
import com.streafy.shiftrandomusers.feature.userlist.presentation.UserListUiState
import com.streafy.shiftrandomusers.feature.userlist.presentation.UserListViewModel

@Composable
fun UserListScreen(
    viewModel: UserListViewModel = viewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    UserListScreen(
        state = state.value,
        onUserClick = {},
        onUpdateUsers = viewModel::updateUsers,
        onDismissError = viewModel::clearError,
        onRetry = viewModel::loadUsers
    )
}

@Composable
private fun UserListScreen(
    state: UserListUiState,
    onUserClick: (String) -> Unit,
    onUpdateUsers: () -> Unit,
    onDismissError: () -> Unit,
    onRetry: () -> Unit
) {
    Scaffold(topBar = {
        AppTopBar(titleText = stringResource(R.string.user_list_screen_title))
    }) { contentPadding ->
        when (state) {
            is UserListUiState.Content -> UserListContent(
                users = state.users,
                updating = state.updating,
                errorMessage = state.errorMessage,
                onUserClick = onUserClick,
                onUpdateUsers = onUpdateUsers,
                onErrorDismiss = onDismissError,
                onRetry = onRetry,
                modifier = Modifier.padding(contentPadding)
            )

            UserListUiState.Initial, UserListUiState.Loading ->
                FullScreenProgressIndicator(
                    modifier = Modifier.padding(contentPadding)
                )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserListContent(
    users: List<User>,
    updating: Boolean,
    errorMessage: String?,
    onUserClick: (String) -> Unit,
    onUpdateUsers: () -> Unit,
    onErrorDismiss: () -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (users.isEmpty()) {
        RetryButtonBox(onRetry)
    } else {
        PullToRefreshBox(
            isRefreshing = updating,
            onRefresh = onUpdateUsers,
            modifier = modifier.padding(horizontal = 16.dp)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(users) { user ->
                    UserCard(
                        user = user, onClick = { onUserClick(user.id) })
                }
            }
        }
    }
    if (errorMessage != null) {
        ErrorDialog(
            onDismissRequest = onErrorDismiss,
            onConfirm = onErrorDismiss,
            errorMessage = errorMessage
        )
    }
}

@Preview
@Composable
private fun UserListScreenPreview() {
    val users = List(10) {
        User(
            id = "$it",
            firstName = "User",
            lastName = "User",
            photoUrl = "https://randomuser.me/api/portraits/med/women/1.jpg",
            address = "Some Address",
            phone = "098-66732533"
        )
    }

    UserListScreen(
        state = UserListUiState.Content(
            users = users,
            updating = false,
            errorMessage = "test"
        ),
        onUserClick = { },
        onUpdateUsers = { },
        onDismissError = { },
        onRetry = { }
    )
}
