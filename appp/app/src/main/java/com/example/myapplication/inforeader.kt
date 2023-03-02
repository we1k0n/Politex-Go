package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class inforeader : AppCompatActivity(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReturnBookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inforeader)
        val db = DB.getDB(this)

        val readerId = intent.getIntExtra(Infobook.EXTRA_ID, 0)
        val firstName = intent.getStringExtra(Infobook.EXTRA_FIRST_NAME)
        val lastName = intent.getStringExtra(Infobook.EXTRA_LAST_NAME)
        val address = intent.getStringExtra(Infobook.EXTRA_ADDRESS)
        val phoneNum = intent.getIntExtra(Infobook.EXTRA_PHONE_NUM, 0)

        recyclerView = findViewById(R.id.RcReaderBook)
        adapter = ReturnBookAdapter(this,db.getDao().readerBook(readerId),this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<TextView>(R.id.RFirst).apply {
            text = firstName
        }
        findViewById<TextView>(R.id.RLast).apply {
            text = lastName
        }
        findViewById<TextView>(R.id.RAddress).apply {
            text = address
        }
        findViewById<TextView>(R.id.RPhone).apply {
            text = phoneNum.toString()
    }
}

    override fun OnItemClickReader(reader: Reader) {

    }

    override fun OnItemClickBook(book: Book) {
        
    }
}
