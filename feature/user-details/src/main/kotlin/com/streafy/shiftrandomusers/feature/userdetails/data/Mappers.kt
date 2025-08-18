package com.streafy.shiftrandomusers.feature.userdetails.data

import com.streafy.shiftrandomusers.core.database.UserEntity
import com.streafy.shiftrandomusers.feature.userdetails.domain.UserDetails

fun UserEntity.toDomainModel() =
    UserDetails(
        id = id,
        firstName = firstName,
        lastName = lastName,
        photoUrl = photoUrl,
        phone = phone,
        email = email,
        streetNumber = streetNumber,
        streetName = streetName,
        city = city,
        state = state,
        country = country,
        latitude = latitude,
        longitude = longitude,
        username = username,
        dateOfBirthDate = dateOfBirthDate,
        dateOfBirthAge = dateOfBirthAge,
        registeredDate = registeredDate,
        registeredAge = registeredAge,
        nationality = nationality
    )