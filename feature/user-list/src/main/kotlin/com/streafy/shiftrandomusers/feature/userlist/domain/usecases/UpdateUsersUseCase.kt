package com.streafy.shiftrandomusers.feature.userlist.domain.usecases

import com.streafy.shiftrandomusers.feature.userlist.domain.UserListRepository

class UpdateUsersUseCase(
    repository: UserListRepository
) : suspend () -> Unit by repository::updateUsers