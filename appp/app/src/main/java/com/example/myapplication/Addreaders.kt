package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityAddbooksBinding
import com.example.myapplication.databinding.ActivityAddreadersBinding

class Addreaders : AppCompatActivity() {
    lateinit var bindingClass : ActivityAddreadersBinding
    lateinit var db: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAddreadersBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        db = DB.getDB(this)
    }
    fun onClick(view: View){
        val reader = Reader(
            null, bindingClass.firstName.text.toString(),
            bindingClass.lastName.text.toString(),
            bindingClass.adressa.text.toString(),
            bindingClass.phone.text.toString().toInt(),0
        )
        ATask(db = db,3) { resalt ->
            if (resalt) {
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
                finish()
            } else {
                runOnUiThread{
                    Toast.makeText(this,"ERROR", Toast.LENGTH_SHORT).show()
                }

            }
        }.execute(reader)
    }
    }

