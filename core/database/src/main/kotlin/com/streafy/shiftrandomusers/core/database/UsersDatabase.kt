package com.streafy.shiftrandomusers.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

fun UsersDatabase(applicationContext: Context) =
    Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        UsersDatabase::class.java,
        "users-database"
    ).build()