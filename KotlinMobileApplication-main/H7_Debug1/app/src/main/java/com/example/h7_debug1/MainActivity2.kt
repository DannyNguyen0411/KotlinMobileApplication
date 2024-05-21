package com.example.h7_debug1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun oldBrowser(view: View) {
        finish()
    }


    fun divideNow(view: View) {
        val numberViewOne = findViewById<EditText>(R.id.nummerOne)
        val numberViewTwo = findViewById<EditText>(R.id.nummerTwo)
        val resultText = findViewById<TextView>(R.id.Answer)

        try {
            val numberOne = numberViewOne.text.toString().toInt()
            val numberTwo = numberViewTwo.text.toString().toInt()

            if (numberTwo == 0) {
                resultText.text = "Kan niet door 0 delen"
            } else {
                val updatedNumber = numberOne / numberTwo
                resultText.text = "Het antwoord is: $updatedNumber"
            }
        } catch (e: NumberFormatException) {
            resultText.text = "Ongeldige invoer. Voer geldige getallen in."
        }
    }
}