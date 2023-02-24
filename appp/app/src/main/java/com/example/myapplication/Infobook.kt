package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Infobook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infobook)

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

    }
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_YEAR = "extra_year"
        const val EXTRA_ROW = "extra_row"
        const val EXTRA_RACK = "extra_rack"
        const val EXTRA_SHELF = "extra_shelf"
    }
}