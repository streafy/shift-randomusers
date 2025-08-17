package com.streafy.shiftrandomusers.feature.userlist.data

import com.streafy.shiftrandomusers.core.network.models.UserDto
import com.streafy.shiftrandomusers.feature.userlist.domain.User

fun UserDto.toDomainModel() =
    User(
        id = login.uuid,
        firstName = name.first,
        lastName = name.last,
        photoUrl = picture.large,
        address = location.city,
        phone = phone
    )