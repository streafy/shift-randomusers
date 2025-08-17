package com.streafy.shiftrandomusers.feature.userlist.domain.usecases

import com.streafy.shiftrandomusers.feature.userlist.domain.UserListRepository
import javax.inject.Inject

class UpdateUsersUseCase @Inject constructor(
    repository: UserListRepository
) : suspend () -> Unit by repository::updateUsers