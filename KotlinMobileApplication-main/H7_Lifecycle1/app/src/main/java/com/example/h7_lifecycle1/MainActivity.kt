package com.example.h7_lifecycle1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var intResume: Int = 0 // Initialize intResume

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Stop has started", "onStart()")
        updateUIWithTime()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i("INFO MainActivity", "onRestoreInstanceState")
        if(savedInstanceState != null) {
            intResume = savedInstanceState.getInt("Aantal Keer")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("INFO MainActivity", "onResume()")

        // Increment intResume counter
        intResume++

        // Update a TextView with a welcome message
        val welcomeTextView = findViewById<TextView>(R.id.textTime)
        welcomeTextView.text = "Welcome back! Resumed $intResume times."
    }


    override fun onPause() {
       super.onPause()
       Log.i("INFO MainActivity", "onPause()")
   }

   override fun onStop() {
       super.onStop()
       Log.i("INFO MainActivity", "onStop()")
   }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            Log.i("INFO MainActivity", "onCreate")
            outState.putInt("Aantal Keer", intResume)
        }
        super.onSaveInstanceState(outState)
    }

   override fun onDestroy() {
       super.onDestroy()
       Log.i("INFO MainActivity", "onDestroy()")
   }

    fun stopApp(view: View) {
        try {
            val textView = findViewById<TextView>(R.id.textView)
            textView.text = "Updated Text"
        } catch (e: Exception) {
            // Handle the specific exception or use a general Exception here
            val textView = findViewById<TextView>(R.id.textView)
            textView.text = "Error: ${e.message}"
        }
    }

    fun changeApp(view: View){
        try {
            val theNumber = findViewById<EditText>(R.id.theNumber)
            val number = theNumber.text.toString().toLong()
            val updatedNumber = number + 1

            val resultText = findViewById<TextView>(R.id.textView)
            resultText.text = "The number is: $updatedNumber"

            theNumber.setText(updatedNumber.toString())
        } catch(e: NumberFormatException) {
            val textViewBericht: TextView = findViewById(R.id.textView)
            textViewBericht.text = "A number! Not a letter!"
        }
        }

    private fun updateUIWithTime() {
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val currentTime = sdf.format(Date())

        // Assuming you have a TextView with ID textViewTime in your layout
        val textViewTime = findViewById<TextView>(R.id.textTime)
        textViewTime.text = "Current time: $currentTime"
    }

    }
