package com.example.userposttodo_jig_feb15.data.repository

import com.example.userposttodo_jig_feb15.data.local.dao.PostDao
import com.example.userposttodo_jig_feb15.data.local.entity.Post
import com.example.userposttodo_jig_feb15.data.remote.service.PostService
import com.example.userposttodo_jig_feb15.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postService: PostService,
    private val postDao: PostDao
) {

    fun getPosts(): Flow<DataState<List<Post>>> = flow {
        emit(DataState.Loading)

        val isDbEmpty = postDao.getPostCount() == 0

        if (isDbEmpty) {
            val result = try {
                val response = postService.getPosts()
                if (response.isSuccessful && response.body() != null) {
                    val postList = response.body()!!.map { it.toPost() }
                    // Inserting posts to DB
                    postDao.insertAllPost(postList)
                    //
                    DataState.Success(postList)
                } else {
                    DataState.Error("Could not fetch any posts")
                }
            } catch (ex: Exception) {
                DataState.Error(ex.message ?: "Unexpected error.")
            }
            emit(result)
        } else {
            // If db not empty return db contents
            val dbResult = postDao.getAllPosts()
            emit(DataState.Success(dbResult))
        }
    }
}