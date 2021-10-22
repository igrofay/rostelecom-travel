package com.rostelecom.rt.module

import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions

class WorkMaps(var googleMap: GoogleMap) {

    init {
        startLogic()
    }

    private fun startLogic() {
        val pos = LatLng(0.0, 0.0)
        googleMap.addMarker(MarkerOptions().position(pos))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pos))
    }
}