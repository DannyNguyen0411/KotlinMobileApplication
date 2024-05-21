package com.example.userlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
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