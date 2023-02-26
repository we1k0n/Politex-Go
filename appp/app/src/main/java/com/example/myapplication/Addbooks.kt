package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityAddbooksBinding
import com.example.myapplication.databinding.ActivityMenuBinding

class Addbooks : AppCompatActivity() {
    lateinit var bindingClass : ActivityAddbooksBinding
    lateinit var db: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAddbooksBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        db = DB.getDB(this)
    }
    fun onClick(view: View){

        val book = Book(
            null, bindingClass.name.text.toString(),
            bindingClass.autor.text.toString(),
            bindingClass.year.text.toString(),
            bindingClass.ryad.text.toString(),
            bindingClass.stelaz.text.toString(),
            bindingClass.polycia.text.toString(),
            intent.getIntExtra("librarianId",0),
            0
        )
        ATask(db = db,2) { resalt ->
            if (resalt) {
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
                finish()
            } else {
                runOnUiThread{
                    Toast.makeText(this,"ERROR", Toast.LENGTH_SHORT).show()
                }

            }
        }.execute(book)
    }
}