package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityAddbooksBinding
import com.example.myapplication.databinding.ActivityAddreadersBinding

class Addreaders : AppCompatActivity() {
    lateinit var bindingClass : ActivityAddreadersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAddreadersBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
    fun onClick(view: View){
        val intent = Intent(this,Menu::class.java)
        startActivity(intent)
        finish()
    }
}
