package com.example.h9_start

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices.getFusedLocationProviderClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d("coordinaten", "Er is geen toestemming verleend voor uitlezen coordinaten")
        } else {
            getFusedLocationProviderClient(this).lastLocation
                .addOnSuccessListener { location: Location? ->
                    Log.d("coordinaten", "${location?.longitude} ${location?.latitude}")
                }
                .addOnFailureListener {
                    Log.d("coordinaten", "error: ${it.localizedMessage}")
                }

        }
    }
}