package com.example.h7_debug1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startBrowser(view: View) {
    try {
        val numberView = findViewById<EditText>(R.id.editNumber)
        val number = numberView.text.toString().toLong()
        val updatedNumber = number + 1


        val resultText = findViewById<TextView>(R.id.resultText)
        resultText.text = "Getal + 1 wordt: $updatedNumber"

        numberView.setText(updatedNumber.toString())
        } catch(e: NumberFormatException) {
            val textViewBericht: TextView = findViewById(R.id.resultText)
        textViewBericht.text = "Je moet hier een getal vullen motherfucker!"
        }
    }

    fun newBrowser(view: View) {

        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}