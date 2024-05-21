package com.example.userlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun backToMain(view: View){
        val intent= Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun login(view: View){
        val intent= Intent(this, MapLoggedInActivity::class.java)
        startActivity(intent)
    }
}