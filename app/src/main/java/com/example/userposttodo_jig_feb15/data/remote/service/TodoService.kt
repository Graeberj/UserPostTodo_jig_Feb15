package com.example.userposttodo_jig_feb15.data.remote.service

import com.example.userposttodo_jig_feb15.data.remote.models.TodoDto
import retrofit2.Response
import retrofit2.http.GET

interface TodoService {

    @GET("todos")
    suspend fun getTodos(): Response<List<TodoDto>>
}