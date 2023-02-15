package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityRegistrationBinding
   lateinit var  db :DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
         db = DB.getDB(this)
    }

    fun OnClick(view: View){
        if(bindingClass.etPassword2.text.toString().length>=8 &&
            bindingClass.etPassword2.text.toString()==bindingClass.etConfirmPassword.text.toString() ){
            val librarian=Librarian(null, bindingClass.etLogin2.text.toString() ,
                bindingClass.etPassword2.text.toString())
            Thread{
                db.getDao().insertLibrarian(librarian)
            }.start()
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun onClickToAuthorization(view: View){
        val intent = Intent(this,AuthorizationActivity::class.java)
        startActivity(intent)
        finish()
    }
}