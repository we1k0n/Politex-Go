package com.example.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Librarian::class,Book::class], version = 1)
abstract class DB :RoomDatabase(){
    abstract fun getDao():Dao

    companion object{
        fun getDB(context: Context): DB{
            return Room.databaseBuilder(context.applicationContext
                ,DB::class.java,
                "library.db").build()
        }
    }
}