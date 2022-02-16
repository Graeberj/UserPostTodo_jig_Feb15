package com.example.userposttodo_jig_feb15.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.userposttodo_jig_feb15.data.local.entity.Post

@Dao
interface PostDao {

    @Insert
    suspend fun insertAllPost(post: List<Post>)

    @Query("SELECT * FROM posts")
    suspend fun getAllPosts(): List<Post>

    @Query("SELECT count(*) FROM posts")
    suspend fun getPostCount(): Int
}