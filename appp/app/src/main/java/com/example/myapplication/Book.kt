package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name="author")
    var author: String,
    @ColumnInfo(name="year")
    var year: String,
    @ColumnInfo(name="row")
    var row: String,
    @ColumnInfo(name="racks")
    var racks: String,
    @ColumnInfo(name="shelf")
    var shelf: String,
    @ColumnInfo(name="librarianId")
    var librarianId: Int,
    @ColumnInfo(name="readerId")
    var readerId: Int


)