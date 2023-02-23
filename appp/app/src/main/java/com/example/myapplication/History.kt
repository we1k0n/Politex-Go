package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name="bookId")
    var bookId :Int,
    @ColumnInfo(name="readerId")
    var readerId :Int,
    @ColumnInfo(name="librarianId")
    var librarianId :Int

)
