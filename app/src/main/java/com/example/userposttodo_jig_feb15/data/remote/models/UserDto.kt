package com.example.userposttodo_jig_feb15.data.remote.models

import com.example.userposttodo_jig_feb15.data.local.entity.user.Address
import com.example.userposttodo_jig_feb15.data.local.entity.user.Company
import com.example.userposttodo_jig_feb15.data.local.entity.user.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class UserDto(
    val id: Int,
    val name: String,
    val username: String?,
    val email: String?,
    val address: Address,
    val phone: String?,
    val website: String?,
    val company: Company
) {

    fun toUser(): User{
        return User(
            id = id,
        name = name,
        username = username ?: "none",
        email = email ?: "no email",
        address = address,
        phone = phone ?: "000-000-0000",
        website = website ?: "nowhere.com",
        company = company
        )
    }
}


