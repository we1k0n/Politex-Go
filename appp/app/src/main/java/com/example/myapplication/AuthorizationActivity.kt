package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class AuthorizationActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }
    fun onClick(view: View){
        if(getString(R.string.password)==bindingClass.etPassword.text.toString() &&
            getString(R.string.login)==bindingClass.etLogin.text.toString()){

        }
        else{
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}