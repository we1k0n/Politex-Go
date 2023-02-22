package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myapplication.databinding.ActivityAddreadersBinding
import com.example.myapplication.databinding.ActivityVorpBinding
import kotlinx.coroutines.launch

class vorp : AppCompatActivity() {
    private lateinit var binding: ActivityVorpBinding
    lateinit var db: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVorpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = DB.getDB(this)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

//    override fun onResume() {
//        super.onResume()
//        lifecycleScope.launch {
//            val bookList = DB(this@vorp).getDao().getAllBook()
//            binding.rcView.apply {
//                layoutManager = LinearLayoutManager(this@vorp)
//                adapter = BookAdapter().apply {
//                    setData(bookList)
//                }
//            }
//        }
//    }
    fun onClick(view: View)
    {
        db.getDao().findBook(binding.editTextTextPersonName.text.toString()).asLiveData().observe(this){
            binding.rcView.apply {
                layoutManager = LinearLayoutManager(this@vorp)
                adapter = BookAdapter().apply {
                    setData(it)
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


