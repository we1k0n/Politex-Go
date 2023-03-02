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
import com.example.myapplication.databinding.ActivityInfobookBinding


class Infobook : AppCompatActivity(), OnItemClickListener {
    lateinit var db: DB
    lateinit var existence: TextView
    lateinit var bindingClass : ActivityInfobookBinding
    var librarianId:Int=0
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReaderBookAdapter
     var readerId:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infobook)
        db = DB.getDB(this)
        bindingClass = ActivityInfobookBinding.inflate(layoutInflater)

        searchView = findViewById(R.id.sReaders)
        recyclerView = findViewById(R.id.rcReaders)
        adapter = ReaderBookAdapter(this,emptyList(),this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val searchView = findViewById<SearchView>(R.id.sReaders)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                findViewById<RecyclerView>(R.id.rcReaders).visibility =View.VISIBLE
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
        if(readerId!=0){
            val history = History(
                null,
                intent.getIntExtra(EXTRA_ID, 0),
                readerId,
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
            }.execute(readerId, intent.getIntExtra(EXTRA_ID, 0))
            existence.text = "Нема"
            view.visibility = View.GONE
        }
        else Toast.makeText(this,"Виберіть читача",Toast.LENGTH_SHORT).show()

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

    override fun OnItemClickReader(reader: Reader) {
        val firstText = findViewById<TextView>(R.id.ReaderFirst)
        val lastText = findViewById<TextView>(R.id.ReaderLast)
        val addressText = findViewById<TextView>(R.id.ReaderAddress)
        val phoneText = findViewById<TextView>(R.id.ReaderPhone)
        findViewById<RecyclerView>(R.id.rcReaders).visibility =View.GONE
        findViewById<TextView>(R.id.firstreader).visibility=View.VISIBLE
        findViewById<TextView>(R.id.lastreader).visibility=View.VISIBLE
        findViewById<TextView>(R.id.addressreader).visibility=View.VISIBLE
        findViewById<TextView>(R.id.numberreader).visibility=View.VISIBLE
        firstText.text = reader.firstName
        lastText.text = reader.lastName
        addressText.text = reader.address
        phoneText.text = reader.phoneNum.toString()
        firstText.visibility=View.VISIBLE
        lastText.visibility=View.VISIBLE
        addressText.visibility=View.VISIBLE
        phoneText.visibility=View.VISIBLE
        readerId= reader.id!!
    }

    override fun OnItemClickBook(book: Book) {

    }
}
