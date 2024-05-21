package com.example.h6_link

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tekstVeld = findViewById<TextView>(R.id.text) as TextView
        val knp = findViewById(R.id.button4) as Button
        val invulVeld = findViewById<TextView>(R.id.naam) as TextView

        knp?.setOnClickListener{
            val str: String = invulVeld.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("tekstKey", str)
            startActivity(intent)
            finish()
        }
    }

    fun startBrowser(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=w-sQRS-Lc9k&ab_channel=KORDHELL"))
        startActivity(browserIntent)
    }

    fun startScherm2(view: View) {
        val bericht = "Fuck you!!! (Have to say it for the MainActivity)"
        val numberView = findViewById<EditText>(R.id.theNumber)
        var number = numberView.text.toString().toInt()
        number += 1 // Increment the number by 1
        numberView.setText(number.toString()) // Update the EditText with the new number

        val changeButton = findViewById<Button>(R.id.button2)

        val filledText = findViewById<EditText>(R.id.naam)
        val textContent = filledText.text.toString()

        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("tekstKey", bericht)
        intent.putExtra("numberKey", number)
        intent.putExtra("textColor", R.color.red)
        intent.putExtra("textContent", textContent)
        startActivity(intent)
    }
}
