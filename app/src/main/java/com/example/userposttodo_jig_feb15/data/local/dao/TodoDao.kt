package com.example.userposttodo_jig_feb15.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.userposttodo_jig_feb15.data.local.entity.Todo

@Dao
interface TodoDao {
    @Insert
    suspend fun insertAllTodo(todo: List<Todo>)

    @Query("SELECT * FROM todos")
    suspend fun getAllTodos(): List<Todo>

    @Query("SELECT count(*) FROM todos")
    suspend fun getTodoCount(): Int
}