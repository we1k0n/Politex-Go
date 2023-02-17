package com.example.myapplication

import android.content.Intent

import android.os.Bundle
import android.view.View
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
     fun onClick(view: View) {
         val login = bindingClass.etLogin.text.toString()
         db.getDao().Authorization(login).asLiveData().observe(this) {
             if (bindingClass.etPassword.text.toString() == it) {
                 var intent = Intent(this, Menu::class.java)
                 startActivity(intent)
                 finish()
             }
         }
     }
    fun onClickToRegistration(view: View){
        var intent = Intent(this,RegistrationActivity::class.java)
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