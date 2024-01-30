package com.example.userlogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.mapbox.maps.MapboxMap

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var mapboxMap: MapboxMap
//    private lateinit var markerViewManager: MarkerViewManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        mapView.getMapAsync {mapboxMap
//            val markerViewManager = MarkerViewManager(mapView, mapboxMap)
//
//            addMarker(markerViewManager, LatLng(51.83, 4.29), "Marker Title", "Marker Description")
//        }
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Set the initial camera position
        val cameraPosition = CameraUpdateFactory.newLatLngZoom(LatLng(LATITUDE, LONGITUDE), 9.0f)

        // Move the camera to the specified position
        googleMap.moveCamera(cameraPosition)

        // Enable zoom controls
        googleMap.uiSettings.isZoomControlsEnabled = true

        // You can add other map configurations or markers here if needed
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    companion object {
        private const val LATITUDE = 51.8
        private const val LONGITUDE = 4.19
    }
}


