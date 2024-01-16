package com.example.locatiethehedgehog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView

/**
 * Example of displaying a map.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mapView = MapView(this)
        setContentView(mapView)
        mapView.mapboxMap
            .apply {
                setCamera(
                    CameraOptions.Builder()
                        .center(Point.fromLngLat(LONGITUDE, LATITUDE))
                        .pitch(0.0)
                        .zoom(9.0)
                        .bearing(0.0)
                        .build()
                )
            }
    }

    companion object {
        private const val LATITUDE = 51.85
        private const val LONGITUDE = 4.33
    }
}