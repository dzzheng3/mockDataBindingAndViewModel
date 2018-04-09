package com.example.dz.mockdatabinding.data

import android.arch.persistence.room.Room
import android.content.Context
import com.example.dz.mockdatabinding.data.database.UserDatabase
import com.example.dz.mockdatabinding.data.table.User

class DBHelper constructor(context: Context) {
    val userDatabase = Room.databaseBuilder(context, UserDatabase::class.java,
            "daily").allowMainThreadQueries().build()!!

    companion object {
        @Volatile
        var INSTANCE: DBHelper? = null

        fun getInstance(context: Context): DBHelper {
            if (INSTANCE == null) {
                synchronized(DBHelper::class) {
                    if (INSTANCE == null) {
                        INSTANCE = DBHelper(context.applicationContext)
                    }
                }
            }
            return INSTANCE!!
        }
    }

    fun insertUser(user: User) {
        userDatabase.userDao().insertUser(user)
    }

    fun deleteUser(user: User) {
        userDatabase.userDao().deleteUser(user)
    }

    fun getUsers(): List<User> {
        return userDatabase.userDao().getUserList()
    }

    fun closeDB() {
        if (userDatabase != null)
            userDatabase.close()
    }
}