package com.example.ec02_lcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class AddAddressActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)


        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val Mi_casa = LatLng(-12.482285, -76.796356)
        val IDAT_SEDE_SJM = LatLng(-12.1555768,-76.9806433)
        val IDAT_SEDE_Lima_Centro = LatLng(-12.0671112,-77.038324)

        map.addMarker(MarkerOptions().title("Mi casa").position(Mi_casa))
        map.addMarker(MarkerOptions().title("IDAT Sede San Juan de Miraflores").position(IDAT_SEDE_SJM))
        map.addMarker(MarkerOptions().title("IDAT Sede Lima Centro").position(IDAT_SEDE_Lima_Centro))


        val bound = LatLngBounds.builder()
        bound.include(Mi_casa)
        bound.include(IDAT_SEDE_SJM)
        bound.include(IDAT_SEDE_Lima_Centro)
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bound.build(), 150))
    }
}