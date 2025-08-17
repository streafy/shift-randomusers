package com.streafy.shiftrandomusers.feature.userlist.domain.usecases

import com.streafy.shiftrandomusers.feature.userlist.domain.User
import com.streafy.shiftrandomusers.feature.userlist.domain.UserListRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    repository: UserListRepository
) : suspend () -> List<User> by repository::getUsers