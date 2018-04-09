package com.example.dz.mockdatabinding.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.dz.mockdatabinding.data.table.User
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("select * from user")
    fun getUserList(): Flowable<List<User>>

    @Delete
    fun deleteUser(user:User)
}