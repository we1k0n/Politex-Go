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

    @Query("SELECT id FROM book WHERE name LIKE :query OR author LIKE :query")
    fun searchBookId(query: String): Int
    @Query("SELECT * FROM history WHERE bookId =:zmina")
    fun searchID(zmina: Int): List<History>

    @Query("SELECT * FROM readers WHERE firstName LIKE :query OR lastName LIKE :query")
    fun searchReaders(query: String): List<Reader>

    @Query("SELECT * FROM book WHERE readerId =:readerId")
    fun readerBook(readerId: Int): List<Book>

    @Query("SELECT * FROM book WHERE id =:bookId")
    fun historyBook(bookId: Int): Flow<List<Book>>
    @Query("SELECT * FROM readers WHERE id =:readerId")
    fun historyReader(readerId: Int): Flow<List<Reader>>
    @Query("SELECT * FROM librarians WHERE id =:librarianId")
    fun historyLibrian(librarianId: Int): Flow<List<Librarian>>

    @Query("SELECT * FROM history")
    fun getHistory(): List<History>
}