package com.example.userposttodo_jig_feb15.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userposttodo_jig_feb15.data.local.dao.PostDao
import com.example.userposttodo_jig_feb15.data.local.entity.Post

@Database(entities = [Post::class], version = 1, exportSchema = true)
abstract class PostDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostDao
}