package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Infobook : AppCompatActivity() {
    lateinit var db: DB
    lateinit var existence: TextView
    var librarianId:Int=0
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReaderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infobook)
        db = DB.getDB(this)

        searchView = findViewById(R.id.sReaders)
        recyclerView = findViewById(R.id.rcReaders)
        adapter = ReaderAdapter(this,emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val searchView = findViewById<SearchView>(R.id.sReaders)
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

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val author = intent.getStringExtra(EXTRA_AUTHOR)
        val year = intent.getStringExtra(EXTRA_YEAR)
        val row = intent.getStringExtra(EXTRA_ROW)
        val rack = intent.getStringExtra(EXTRA_RACK)
        val shelf = intent.getStringExtra(EXTRA_SHELF)

        val firstName = intent.getStringExtra(EXTRA_FIRST_NAME)
        val lastName = intent.getStringExtra(EXTRA_LAST_NAME)
        val address = intent.getStringExtra(EXTRA_ADDRESS)
        val phoneNum = intent.getIntExtra(EXTRA_PHONE_NUM, 0)

        findViewById<TextView>(R.id.ReaderFirst).apply {
            text = firstName
        }
        findViewById<TextView>(R.id.ReaderLast).apply {
            text = lastName
        }
        findViewById<TextView>(R.id.ReaderAddress).apply {
            text = address
        }
        findViewById<TextView>(R.id.ReaderPhone).apply {
            text = phoneNum.toString()
        }

        findViewById<TextView>(R.id.infoNameBook).apply {
            text = name
        }
        findViewById<TextView>(R.id.infoAuthorBook).apply {
            text = author
        }
        findViewById<TextView>(R.id.infoYearBook).apply {
            text = year.toString()
        }
        findViewById<TextView>(R.id.infoRowBook).apply {
            text = row.toString()
        }
        findViewById<TextView>(R.id.infoRackBook).apply {
            text = rack.toString()
        }
        findViewById<TextView>(R.id.infoShelfBook).apply {
            text = shelf.toString()
        }
        existence = findViewById<TextView>(R.id.existence)
        if (intent.getIntExtra(EXTRA_READER_ID, 0) == 0) {
            existence.text = "Є"
        } else {
            existence.text = "Нема"
            findViewById<Button>(R.id.button2).apply {
                visibility = View.GONE
            }
        }
        getSharedPreferences(getString(R.string.app_shared_prefs), Context.MODE_PRIVATE)?.let { sharedPreferences ->
            librarianId = sharedPreferences.getInt(getString(R.string.librarian_id),100)
        }
    }


    fun onClickGiveBook(view: View) {
        val history = History(
            null,
            intent.getIntExtra(EXTRA_ID, 0),
            0,
            librarianId
        )
        ATask(db = db, 4) { resalt ->
            if (resalt) {
            } else {
                runOnUiThread {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }

            }
        }.execute(history)
        val array = intArrayOf(1, intent.getIntExtra(EXTRA_ID, 0))
        ATask(db = db, 5) { resalt ->
            if (resalt) {
            } else {
                runOnUiThread {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }

            }
        }.execute(1, intent.getIntExtra(EXTRA_ID, 0))
        existence.text = "Нема"
        view.visibility = View.GONE
//        findViewById<Button>(R.id.button4).apply {
//            visibility = View.VISIBLE
//        }
    }

    fun onClickReturnBook(view: View) {
        val array = intArrayOf(1, intent.getIntExtra(EXTRA_ID, 0))
        ATask(db = db, 5) { resalt ->
            if (resalt) {
            } else {
                runOnUiThread {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }

            }
        }.execute(0, intent.getIntExtra(EXTRA_ID, 0))
        existence.text = "Є"
        view.visibility = View.GONE
        findViewById<Button>(R.id.button2).apply {
            visibility = View.VISIBLE
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_ROW = "extra_row"
        const val EXTRA_RACK = "extra_rack"
        const val EXTRA_SHELF = "extra_shelf"
        const val EXTRA_LIBRARIAN_ID = "extra_librarianId"
        const val EXTRA_READER_ID = "extra_readerId"
        const val EXTRA_FIRST_NAME = "extra_first_name"
        const val EXTRA_LAST_NAME = "extra_last_name"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_PHONE_NUM = "extra_phone_num"
    }
}
