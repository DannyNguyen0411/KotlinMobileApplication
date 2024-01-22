package com.example.userlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startLogin(view: View){
        val intent= Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun startSignIn(view: View){
        val intent= Intent(this, SignIn::class.java)
        startActivity(intent)
    }
}