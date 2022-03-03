package com.example.userposttodo_jig_feb15.data.local.entity.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address(
    @PrimaryKey(autoGenerate = true)
    val key: Int? = null,
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "suite")
    val suite: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "zipcode")
    val zipcode: String,
    @ColumnInfo(name = "geo")
    val geo: Geo

)




