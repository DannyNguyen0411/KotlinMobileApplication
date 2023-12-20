package com.example.h6_link

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val berichtTekst = intent.getStringExtra("tekstKey")
        val textViewBericht = findViewById<TextView>(R.id.text2)
        textViewBericht.text = berichtTekst

        val buttonField = findViewById(R.id.button) as Button
        val textColor = intent.getIntExtra("textColor", android.R.color.black)
        // Set the text color
        buttonField.setBackgroundColor(ContextCompat.getColor(this, textColor))

        val filledText = findViewById<EditText>(R.id.naam2)
        val textContent = intent.getStringExtra("textContent")
        filledText.setText(textContent)


        val numberResult = intent.getIntExtra("numberKey", 2) // Provide a default value if the key is not found
        val numberView = findViewById<EditText>(R.id.theNumber2)
        numberView.setText(numberResult.toString())
    }

    fun startTest(view: View){
        val browserIntent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=w-sQRS-Lc9k&ab_channel=KORDHELL"))
        startActivity(browserIntent)
    }

    fun startScherm1 (view: View) {
        finish()
    }
}