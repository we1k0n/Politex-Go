package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "librarians",indices = [Index(value = ["login"], unique = true)])
data class Librarian(
    @PrimaryKey(autoGenerate = true)
    var id: Int? =null,
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "password")
    var password: String
)
