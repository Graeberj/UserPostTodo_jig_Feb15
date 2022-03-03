package com.example.userposttodo_jig_feb15.data.local.entity.user

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Geo(
    @PrimaryKey(autoGenerate = true)
    val key: Int? = null,
    @ColumnInfo(name = "lat")
    val lat: String,
    @ColumnInfo(name = "lng")
    val lng: String,
)


