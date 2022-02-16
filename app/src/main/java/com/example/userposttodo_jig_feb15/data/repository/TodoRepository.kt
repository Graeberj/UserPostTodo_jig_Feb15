package com.example.userposttodo_jig_feb15.data.repository

import com.example.userposttodo_jig_feb15.data.local.dao.TodoDao
import com.example.userposttodo_jig_feb15.data.local.entity.Todo
import com.example.userposttodo_jig_feb15.data.remote.service.TodoService
import com.example.userposttodo_jig_feb15.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val todoService: TodoService,
    private val todoDao: TodoDao
) {

    fun getTodos(): Flow<DataState<List<Todo>>> = flow {
        emit(DataState.Loading)

        val isDbEmpty = todoDao.getTodoCount() == 0

        if (isDbEmpty) {
            val result = try {
                val response = todoService.getTodos()
                if (response.isSuccessful && response.body() != null) {
                    val todoList = response.body()!!.map { it.toTodo() }

                    todoDao.insertAllTodo(todoList)

                    DataState.Success(todoList)
                } else {
                    DataState.Error("could not fetch any todos")
                }
            } catch (ex: Exception){
                DataState.Error(ex.message ?: "unexpected error")
            }
            emit(result)
        } else {
            val dbResult = todoDao.getAllTodos()
            emit(DataState.Success(dbResult))
        }
    }
}