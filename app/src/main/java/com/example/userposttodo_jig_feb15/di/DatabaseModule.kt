package com.example.userposttodo_jig_feb15.di

import android.content.Context
import androidx.room.Room
import com.example.userposttodo_jig_feb15.data.local.PostDatabase
import com.example.userposttodo_jig_feb15.data.local.TodoDatabase
import com.example.userposttodo_jig_feb15.data.local.UserDatabase
import com.example.userposttodo_jig_feb15.data.local.dao.PostDao
import com.example.userposttodo_jig_feb15.data.local.dao.TodoDao
import com.example.userposttodo_jig_feb15.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesPostDatabase(
        @ApplicationContext context: Context
    ): PostDatabase {
        return Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            "post_database"
        ).build()
    }

    @Provides
    fun providesPostDao(database: PostDatabase): PostDao {
        return database.getPostDao()
    }
    @Provides
    @Singleton
    fun providesTodoDatabase(
        @ApplicationContext context: Context
    ): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    fun providesTodoDao(database: TodoDatabase): TodoDao {
        return database.getTodoDao()
    }
    @Provides
    @Singleton
    fun providesUserDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "todo_database"
        ).build()
    }

    @Provides
    fun providesUserDao(database: UserDatabase): UserDao {
        return database.getUserDao()
    }
}