package com.example.myapplication
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insertLibrarian(librarian: Librarian)
    @Query("SELECT id FROM librarians where login= :login")
    fun Authorization(login :String):Int
}