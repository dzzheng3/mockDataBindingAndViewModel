package com.example.dz.mockdatabinding.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.dz.mockdatabinding.data.Converters
import com.example.dz.mockdatabinding.data.dao.UserDao
import com.example.dz.mockdatabinding.data.table.User

@Database(entities = arrayOf(User::class), version = 1)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}