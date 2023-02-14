package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityAddbooksBinding
import com.example.myapplication.databinding.ActivityMenuBinding

class Addbooks : AppCompatActivity() {
    lateinit var bindingClass : ActivityAddbooksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAddbooksBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
    fun onClick(view: View){
        val intent = Intent(this,Menu::class.java)
        startActivity(intent)
        finish()
    }
}