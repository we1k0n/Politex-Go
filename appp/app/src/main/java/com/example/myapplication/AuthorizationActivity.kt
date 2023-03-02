package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.myapplication.databinding.ActivityMainBinding


class AuthorizationActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    lateinit var db: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        db = DB.getDB(this)
    }

    @SuppressLint("SuspiciousIndentation")
    fun onClick(view: View) {
        val login = bindingClass.etLogin.text.toString()
        val password = bindingClass.etPassword.text.toString()
        db.getDao().Authorization(login,password).asLiveData().observe(this) {
            if (it !=null) {
                getSharedPreferences(getString(R.string.app_shared_prefs), Context.MODE_PRIVATE)?.let { sharedPreferences ->
                        with (sharedPreferences.edit()) {
                            putInt(getString(R.string.librarian_id), it)
                            apply()
                        }
                    }
                var intent = Intent(this, Menu::class.java)
                intent.putExtra("librarianId",it)
                startActivity(intent)
                finish()
            }else
            Toast.makeText(this,"Пароль або логін неправильний", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickToRegistration(view: View) {
        var intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
        finish()
    }
    //AsyncTask.execute { // Insert Data
    //  runOnUiThread {
    //bindingClass.textView.text = id
    //  }

    // }

//        var id :Int?=10
////        Thread{
//              id=db.getDao().Authorization(login)
////            id=112
////        }.start()
//        bindingClass.textView.text=id.toString()
//        if(getString(R.string.password)==bindingClass.etPassword.text.toString() &&
//            getString(R.string.login)==bindingClass.etLogin.text.toString()){
//            val intent = Intent(this,Menu::class.java)
//            startActivity(intent)
//            finish()
//        }
//        else{
//            val intent = Intent(this,RegistrationActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

}