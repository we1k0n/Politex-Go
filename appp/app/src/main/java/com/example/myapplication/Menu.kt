package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    lateinit var bindingClass : ActivityMenuBinding
    var librarianId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        librarianId=intent.getIntExtra("librarianId",0)
    }
    fun AddBook (view: View) {
        val intent = Intent(this,Addbooks::class.java)
        intent.putExtra("librarianId",librarianId)
        startActivity(intent)
//        finish()
    }
    fun AddReaders(view: View){
        val intent = Intent(this,Addreaders::class.java)
        intent.putExtra("librarianId",librarianId)
        startActivity(intent)

//        finish()
    }
    fun vorp(view: View){
        val intent = Intent(this,vorp::class.java)
        intent.putExtra("librarianId",librarianId)
        startActivity(intent)
    //finish()
    }
    fun history(view: View){
        val intent = Intent(this,historyofbook::class.java)
        intent.putExtra("librarianId",librarianId)
        startActivity(intent)

        //finish()
    }
    fun returnbook(view: View){
        val intent = Intent(this,Return::class.java)
        intent.putExtra("librarianId",librarianId)
        startActivity(intent)

        //finish()
    }
}