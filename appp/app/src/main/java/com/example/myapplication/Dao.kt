package com.example.myapplication

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertLibrarian(librarian: Librarian)

    @Insert
    fun insertBook(book: Book)

    @Insert
    fun insertReader(reader: Reader)

    @Query("SELECT id FROM librarians where login=:login AND password=:password")
    fun Authorization(login: String,password: String): Flow<Int>

    @Query("SELECT * FROM book where name LIKE '%' || :name || '%';")
    fun findBook(name: String): Flow<List<Book>>

    @Query("SELECT * FROM book ORDER BY id DESC")
    suspend fun getAllBook(): List<Book>

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}