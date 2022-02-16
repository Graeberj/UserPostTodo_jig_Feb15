package com.example.userposttodo_jig_feb15.data.remote.models

import com.example.userposttodo_jig_feb15.data.local.entity.Todo
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TodoDto(
    val userId: Int?,
    val id: Int,
    val title: String?,
    val completed: Boolean
) {


    fun toTodo(): Todo {
        return Todo(
            userId = userId ?: 0,
            id = id,
            title = title ?: "No title",
            completed = completed
        )
    }
}