package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    lateinit var bindingClass : ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
    fun AddBook (view: View) {
        val intent = Intent(this,Addbooks::class.java)
        startActivity(intent)
        finish()
    }
    fun AddReaders(view: View){
        val intent = Intent(this,Addreaders::class.java)
        startActivity(intent)
        finish()
    }
    fun vorp(view: View){
        val intent = Intent(this,vorp::class.java)
        startActivity(intent)
        finish()
    }
}