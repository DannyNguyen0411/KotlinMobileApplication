package com.example.h8_sensoren

import android.hardware.Sensor
import android.hardware.SensorManager
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private lateinit var sensorManager: SensorManager
private var lichtSensorInfo: Sensor? = null
private var pressureSensorInfo: Sensor? = null


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        infoSensor()
    }

    private fun infoSensor() {
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        lichtSensorInfo = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        pressureSensorInfo = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)

        if (lichtSensorInfo != null) {
            Log.i("INFOsensor", "Light sensor found: ${lichtSensorInfo!!.name}")
        } else {
            Log.i("INFOsensor", "Light sensor not found on this device.")
        }

        if (pressureSensorInfo != null) {
            Log.i("INFOsensor", "Pressure sensor found: ${pressureSensorInfo!!.name}")
        } else {
            Log.i("INFOsensor", "Pressure sensor not found on this device.")
        }

        lichtSensorInfo?.let {
            Log.i("INFOsensor", "Light sensor found: ${it.name}")
        } ?: run {
            Log.i("INFOsensor", "Light sensor not found on this device.")
        }

        pressureSensorInfo?.let {
            Log.i("INFOsensor", "Pressure sensor found: ${it.name}")
        } ?: run {
            Log.i("INFOsensor", "Pressure sensor not found on this device.")
        }


    }


    private val lightSensorListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Handle accuracy changes
        }


        override fun onSensorChanged(event: SensorEvent?) {
            if (event?.sensor?.type == Sensor.TYPE_LIGHT) {
                val lightValue = event.values[0]
                Log.i("SENSOR_EVENT", "Light sensor value: $lightValue")
                // Add your logic based on the light sensor data
            }
        }
    }

    private val pressureSensorListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Handle accuracy changes for the pressure sensor
        }

        override fun onSensorChanged(event: SensorEvent?) {
            if (event?.sensor?.type == Sensor.TYPE_PRESSURE) {
                val pressureValue = event.values[0]
                Log.i("SENSOR_EVENT", "Pressure sensor value: $pressureValue")
                // Add your logic based on the pressure sensor data
            }
        }
    }

    // Register the listeners in onResume
    override fun onResume() {
        super.onResume()
        if (lichtSensorInfo != null) {
            sensorManager.registerListener(lightSensorListener, lichtSensorInfo, SensorManager.SENSOR_DELAY_NORMAL)
        }

        if (pressureSensorInfo != null) {
            sensorManager.registerListener(pressureSensorListener, pressureSensorInfo, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    // Unregister the listeners in onPause to save battery
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(lightSensorListener)
        sensorManager.unregisterListener(pressureSensorListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        sensorManager.unregisterListener(lightSensorListener)
        sensorManager.unregisterListener(pressureSensorListener)
    }

}