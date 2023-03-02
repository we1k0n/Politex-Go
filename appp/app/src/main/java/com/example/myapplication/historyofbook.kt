package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class historyofbook : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HistoryAdapter
    private lateinit var searchView: SearchView
    lateinit var db: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historyofbook)
        db = DB.getDB(this)

        recyclerView = findViewById(R.id.rcHistory)
        searchView = findViewById(R.id.searchHistory)
        adapter = HistoryAdapter(this,db.getDao().getHistory(),db,this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { searchQuery ->
                    var his: List<History>
                    var book = 0
                    if(searchQuery!=""){
                        book = db.getDao().searchBookId("%$searchQuery%")
                        if (book != 0)
                            his = db.getDao().searchID(book)
                        else  his = db.getDao().getHistory()
                    }
                    else his = db.getDao().getHistory()
                    adapter.historys = his
                    adapter.notifyDataSetChanged()
                }
                return true
            }
        })
    }
}