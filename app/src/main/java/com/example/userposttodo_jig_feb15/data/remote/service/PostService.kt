package com.example.userposttodo_jig_feb15.data.remote.service

import com.example.userposttodo_jig_feb15.data.remote.models.PostDto
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getPosts(): Response<List<PostDto>>
}