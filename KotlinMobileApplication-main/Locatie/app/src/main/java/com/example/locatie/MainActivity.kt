package com.example.locatie

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import android.widget.Button
import android.view.View
import android.content.Intent
import android.net.Uri


class MainActivity : ComponentActivity() {
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create a map programmatically and set the initial camera
        mapView = MapView(this)
        mapView.mapboxMap.setCamera(
            CameraOptions.Builder()
                .center(Point.fromLngLat(-98.0, 39.5))
                .pitch(0.0)
                .zoom(2.0)
                .bearing(0.0)
                .build()
        )
// Add the map view to the activity (you can also add it to other views as a child)
        setContentView(mapView)

        val button = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.serebii.net/pokedex-sv/hydrapple/"))
        startActivity(button)
    }


}