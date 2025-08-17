package com.streafy.shiftrandomusers.feature.userlist.data

import com.streafy.shiftrandomusers.core.database.UserEntity
import com.streafy.shiftrandomusers.core.network.models.UserDto
import com.streafy.shiftrandomusers.feature.userlist.domain.User

fun UserDto.toDatabaseEntity() =
    UserEntity(
        id = login.uuid,
        firstName = name.first,
        lastName = name.last,
        photoUrl = picture.large,
        phone = phone,
        email = email,
        streetNumber = location.street.number,
        streetName = location.street.name,
        city = location.city,
        state = location.state,
        country = location.country,
        latitude = location.coordinates.latitude,
        longitude = location.coordinates.longitude,
        username = login.username,
        dateOfBirthDate = dateOfBirth.date,
        dateOfBirthAge = dateOfBirth.age,
        registeredDate = registered.date,
        registeredAge = registered.age,
        nationality = nationality
    )

fun UserEntity.toDomainModel() =
    User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        photoUrl = photoUrl,
        address = city,
        phone = phone
    )