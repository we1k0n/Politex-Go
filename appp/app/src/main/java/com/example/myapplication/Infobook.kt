package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Infobook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infobook)

        val name = intent.getStringExtra(EXTRA_NAME)

        findViewById<TextView>(R.id.infoNameBook).apply {
            text = name
        }

    }
    companion object{
        const val EXTRA_NAME = "extra_name"
    }
}