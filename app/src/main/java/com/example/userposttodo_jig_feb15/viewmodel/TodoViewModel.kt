package com.example.userposttodo_jig_feb15.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.userposttodo_jig_feb15.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todos = todoRepository.getTodos().asLiveData(viewModelScope.coroutineContext)
}