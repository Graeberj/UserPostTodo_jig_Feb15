package com.example.userposttodo_jig_feb15.data.local.entity.user


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.userposttodo_jig_feb15.data.local.entity.user.Address
import com.example.userposttodo_jig_feb15.data.local.entity.user.Company

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val key: Int? = null,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "address")
    val address: Address,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "website")
    val website: String,
    @ColumnInfo(name = "company")
    val company: Company
)