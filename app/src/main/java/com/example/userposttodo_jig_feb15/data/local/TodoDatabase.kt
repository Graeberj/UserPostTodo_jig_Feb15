package com.example.userposttodo_jig_feb15.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userposttodo_jig_feb15.data.local.dao.TodoDao
import com.example.userposttodo_jig_feb15.data.local.entity.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = true)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun getTodoDao(): TodoDao
}