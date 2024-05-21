package com.example.h8_oefenlichtsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var gyrometer: Sensor? = null
    private var numberOfDice: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyrometer = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        // Check if the accelerometer is available on the device
        if (accelerometer != null) {
            // Register the sensor listener
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        } else {
            Log.i("sensorInfo", "Accelerometer not found on this device.")
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Unregister the sensor listener when the activity is destroyed
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Handle accuracy changes if needed
    }

    override fun onSensorChanged(event: SensorEvent) {
        // Shake detection logic
        val xValue = event.values[0]
        val yValue = event.values[1]
        val zValue = event.values[2]

        val acceleration = Math.sqrt((xValue * xValue + yValue * yValue + zValue * zValue).toDouble())

        if (acceleration > 12) { // Adjust the threshold based on your testing
            rollDice()
        }
    }

    private fun rollDice() {
        val randomValues: List<Int> = (1..6).map { Random.nextInt(1, 7) }
        val number = findViewById<TextView>(R.id.number) as TextView

        if (numberOfDice == 1) {
            val result = randomValues[0]
            Log.i("diceRoll", "Single die roll result: $result")
            number.text = "Single die roll result: $result"
        } else {
            val result1 = randomValues[0]
            val result2 = randomValues[1]
            Log.i("diceRoll", "Two dice roll results: $result1 and $result2")
            number.text = "Two dice roll results: $result1 and $result2"
        }
    }
}
