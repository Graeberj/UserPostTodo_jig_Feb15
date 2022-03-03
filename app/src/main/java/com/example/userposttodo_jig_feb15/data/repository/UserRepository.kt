package com.example.userposttodo_jig_feb15.data.repository

import androidx.room.Database
import com.example.userposttodo_jig_feb15.data.local.dao.UserDao
import com.example.userposttodo_jig_feb15.data.local.entity.user.User
import com.example.userposttodo_jig_feb15.data.remote.service.UserService
import com.example.userposttodo_jig_feb15.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao
) {

    fun getUsers(): Flow<DataState<List<User>>> = flow {
        emit(DataState.Loading)

        val isDbEmpty = userDao.getUserCount() == 0

        if (isDbEmpty) {
            val result = try {
                val response = userService.getUsers()
                if (response.isSuccessful && response.body() != null) {
                    val userList = response.body()!!.map { it.toUser() }

                    userDao.insertAllUser(userList)

                    DataState.Success(userList)
                } else {
                    DataState.Error("could not fetch any users")
                }
            } catch (ex: Exception){
                DataState.Error(ex.message ?: "unexpected error")
            }
            emit(result)
        } else {
            val dbResult = userDao.getAllUsers()
            emit(DataState.Success(dbResult))
        }
    }
}