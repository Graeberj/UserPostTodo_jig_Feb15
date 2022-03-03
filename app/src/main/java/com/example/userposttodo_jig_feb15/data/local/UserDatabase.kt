package com.example.userposttodo_jig_feb15.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userposttodo_jig_feb15.data.local.dao.UserDao
import com.example.userposttodo_jig_feb15.data.local.entity.user.User

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}