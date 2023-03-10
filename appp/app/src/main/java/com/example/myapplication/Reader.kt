package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "readers",indices = [Index(value = ["phoneNum"], unique = true)])
data class Reader(
    @PrimaryKey(autoGenerate = true)
    var id: Int? =null,
    @ColumnInfo(name="firstName")
    var firstName: String,
     @ColumnInfo(name="lastName")
    var lastName: String,
     @ColumnInfo(name="address")
    var address: String,
     @ColumnInfo(name="phoneNum")
    var phoneNum: Int,
    @ColumnInfo(name="librarianId")
    var librarianId: Int

)
