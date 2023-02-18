package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityAddreadersBinding
import com.example.myapplication.databinding.ActivityVorpBinding

class vorp : AppCompatActivity() {
    lateinit var binding: ActivityVorpBinding
    private val adapter = BookAdapter()
    private val imageIdList = listOf(R.drawable.image1,R.drawable.image2)
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVorpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@vorp, 3)
            rcView.adapter = adapter
            BaddIM.setOnClickListener {
                if(index > 1) index = 0
                val book = BookList(imageIdList[index], "Image $index")
                adapter.addBook(book)
                index++
            }
        }
    }
}