package com.example.userposttodo_jig_feb15.data.remote.models

import com.example.userposttodo_jig_feb15.data.local.entity.Post
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PostDto(
    val userId: Int?,
    val id: Int,
    val title: String?,
    val body: String
) {


    fun toPost(): Post {
        return Post(
            userId = userId ?: 0,
            id = id,
            title = title ?: "No title",
            body = body
        )
    }
}