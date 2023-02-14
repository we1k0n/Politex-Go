package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityAddreadersBinding
import com.example.myapplication.databinding.ActivityVorpBinding

class vorp : AppCompatActivity() {
    lateinit var bindingClass : ActivityVorpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityVorpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
}