package com.example.userposttodo_jig_feb15.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val key: Int? = null,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "completed")
    val completed: Boolean
)