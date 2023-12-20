package com.example.h5_verwerkendata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tekstVeld = findViewById<TextView>(R.id.Text1) as TextView
        val knp = findViewById(R.id.button) as Button
        val invulVeld = findViewById<TextView>(R.id.editTextText) as TextView

        knp?.setOnClickListener{
            val str: String = invulVeld.text.toString()
            tekstVeld.text = str
        }
    }
}