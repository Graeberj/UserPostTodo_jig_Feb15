package com.example.userposttodo_jig_feb15.utils

sealed class DataState<out T> {
    object Loading: DataState<Nothing>()
    data class Success<T>(val data: T): DataState<T>()
    data class Error(val msg: String): DataState<Nothing>()
}