package com.streafy.shiftrandomusers.feature.userdetails.domain

import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    repository: UserDetailsRepository
) : suspend (String) -> UserDetails by repository::getUserDetails