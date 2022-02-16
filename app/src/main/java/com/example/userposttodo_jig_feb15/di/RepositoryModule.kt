package com.example.userposttodo_jig_feb15.di

import com.example.userposttodo_jig_feb15.data.local.dao.PostDao
import com.example.userposttodo_jig_feb15.data.local.dao.TodoDao
import com.example.userposttodo_jig_feb15.data.remote.service.PostService
import com.example.userposttodo_jig_feb15.data.remote.service.TodoService
import com.example.userposttodo_jig_feb15.data.repository.PostRepository
import com.example.userposttodo_jig_feb15.data.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesPostRepository(
        postService: PostService,
        postDao: PostDao,
    ): PostRepository {
        return PostRepository(postService, postDao)
    }

    @Singleton
    @Provides
    fun providesTodoRepository(
        todoService: TodoService,
        todoDao: TodoDao
    ): TodoRepository {
        return TodoRepository(todoService, todoDao)
    }

}

