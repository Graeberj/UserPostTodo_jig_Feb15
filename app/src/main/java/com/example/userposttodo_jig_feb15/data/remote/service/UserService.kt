package com.example.userposttodo_jig_feb15.data.remote.service

import com.example.userposttodo_jig_feb15.data.remote.models.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers(): Response<List<UserDto>>
}