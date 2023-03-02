package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Query

class Return : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReaderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return)
        val db = DB.getDB(this)

        searchView = findViewById(R.id.SearchReturn)
        recyclerView = findViewById(R.id.rcReturn)
        adapter = ReaderAdapter(this,emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val searchView = findViewById<SearchView>(R.id.SearchReturn)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchQuery ->
                    val reader = db.getDao().searchReaders("%$searchQuery%")
                    adapter.readers = reader
                    adapter.notifyDataSetChanged()
                }
                return true
            }
        })

    }
}