package com.streafy.shiftrandomusers.core.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    @ColumnInfo("fist_name") val firstName: String,
    @ColumnInfo("last_name") val lastName: String,
    @ColumnInfo("photo_url") val photoUrl: String,
    val phone: String,
    val email: String,
    @ColumnInfo("street_number") val streetNumber: Int,
    @ColumnInfo("street_name") val streetName: String,
    val city: String,
    val state: String,
    val country: String,
    val latitude: String,
    val longitude: String,
    val username: String,
    @ColumnInfo("date_of_birth_date") val dateOfBirthDate: String,
    @ColumnInfo("date_of_birth_age") val dateOfBirthAge: Int,
    @ColumnInfo("registered_date") val registeredDate: String,
    @ColumnInfo("registered_age") val registeredAge: Int,
    val nationality: String
)