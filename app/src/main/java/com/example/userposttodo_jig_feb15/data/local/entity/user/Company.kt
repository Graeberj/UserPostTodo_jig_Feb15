package com.example.userposttodo_jig_feb15.data.local.entity.user

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Company(
    @PrimaryKey(autoGenerate = true)
    val key: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "catchPhrase")
    val catchPhrase: String,
    @ColumnInfo(name = "bs")
    val bs: String
)
