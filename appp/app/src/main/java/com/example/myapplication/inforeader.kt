package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class inforeader : AppCompatActivity(), OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReturnBookAdapter
    lateinit var db: DB
    var bookId=0
    var readerId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inforeader)
         db = DB.getDB(this)

        readerId = intent.getIntExtra(Infobook.EXTRA_ID, 0)
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
        findViewById<ConstraintLayout>(R.id.Accept).visibility= View.VISIBLE
        bookId=book.id!!
    }
    fun onClickCancel(view: View){
        findViewById<ConstraintLayout>(R.id.Accept).visibility= View.GONE
    }
    fun onClickAccept(view: View){
        ATask(db = db, 5) { resalt ->
            if (resalt) {
                runOnUiThread {
                    adapter = ReturnBookAdapter(this,db.getDao().readerBook(readerId),this)
                    recyclerView.adapter = adapter
                }
            } else {
                runOnUiThread {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        }.execute(0, bookId)
        findViewById<ConstraintLayout>(R.id.Accept).visibility= View.GONE
//        adapter = ReturnBookAdapter(this,db.getDao().readerBook(readerId),this)
//        recyclerView.adapter = adapter
    }
}
