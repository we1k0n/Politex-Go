package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myapplication.databinding.ActivityAddreadersBinding
import com.example.myapplication.databinding.ActivityVorpBinding
import kotlinx.coroutines.launch

class vorp : AppCompatActivity() {
    private lateinit var binding: ActivityVorpBinding
    private val adapter = BookAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVorpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val bookList = DB(this@vorp).getDao().getAllBook()
            binding.rcView.apply {
                layoutManager = LinearLayoutManager(this@vorp)
                adapter = BookAdapter().apply {
                    setData(bookList)
                }
            }
        }

    }
//    private fun initSearchView(){
//        (activity as MainActivity).el.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                // запускается, когда мы нажимаем лупу на виртуальной клавиатуре
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                // запускается каждый раз, когда мы вводим очередную букву
//                searchText = newText!!
//                fillAdapter()
//                return true
//            }
//        })
}


