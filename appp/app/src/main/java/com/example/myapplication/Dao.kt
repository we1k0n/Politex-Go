package com.example.myapplication

import androidx.lifecycle.LiveData
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

    @Insert
    fun insertHistory(history: History)

    @Query("SELECT id FROM librarians where login=:login AND password=:password")
    fun Authorization(login: String,password: String): Flow<Int>

    @Query("SELECT * FROM book where name LIKE '%' || :name || '%';")
    fun findBook(name: String): Flow<List<Book>>

    @Query("update book set readerId=:readerId where id=:bookId;")
    fun giveBook(readerId: Int,bookId: Int)

    @Query("SELECT * FROM book WHERE name LIKE :query OR author LIKE :query OR year LIKE :query")
    fun search(query: String): List<Book>

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM readers WHERE firstName LIKE :query OR lastName LIKE :query")
    fun searchReaders(query: String): List<Reader>
}