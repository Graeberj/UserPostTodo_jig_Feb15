package com.example.userposttodo_jig_feb15.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.userposttodo_jig_feb15.data.local.entity.user.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertAllUser(user: List<User>)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT count(*) FROM users")
    suspend fun getUserCount(): Int
}