package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityRegistrationBinding
    lateinit var db: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        db = DB.getDB(this)
    }

    fun OnClick(view: View) {
        if (bindingClass.etPassword2.text.toString().length >= 8 &&
            bindingClass.etPassword2.text.toString() == bindingClass.etConfirmPassword.text.toString()
        ) {
            val librarian = Librarian(
                null, bindingClass.etLogin2.text.toString(),
                bindingClass.etPassword2.text.toString()
            )
            ATask(db = db,1) { resalt ->
                if (resalt) {
                    val intent = Intent(this, AuthorizationActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    runOnUiThread{
                        Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
                    }

                }
            }.execute(librarian)


        }
    }

    fun onClickToAuthorization(view: View) {
        val intent = Intent(this, AuthorizationActivity::class.java)
        startActivity(intent)
        finish()
    }


}