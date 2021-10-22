package com.rostelecom.rt.module

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.model.*
import com.rostelecom.rt.R
import com.rostelecom.rt.feature.app.App

class WorkMaps(var googleMap: GoogleMap) {

    init {
        startLogic()
    }

    private fun startLogic() {

        googleMap.uiSettings.apply {
            isZoomControlsEnabled = false
            isMapToolbarEnabled = false
            isCompassEnabled = false
        }

        val pos = LatLng(0.0, 0.0)
        googleMap.addMarker(MarkerOptions().position(pos))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pos))

        addPolyline()

    }

    private fun addPolyline() {
        val polylineOptions = PolylineOptions()
            .color(Color.RED)
            .geodesic(false)
            .width(13f)
            .jointType(JointType.BEVEL)

        polylineOptions.add(LatLng(0.0, 0.0))
        polylineOptions.add(LatLng(1.0, 1.0))
        polylineOptions.add(LatLng(10.0, 2.0))

        googleMap.addPolyline(polylineOptions)



    }

    private fun addMarkers() {
        googleMap.addMarker(
            MarkerOptions()
                .position(LatLng(0.0, 0.0))
                .icon(bitmapDescriptorFromVector(App.appContext, R.drawable.ic_logo))
        )
    }

    private fun bitmapDescriptorFromVector(
        context: Context,
        @DrawableRes vectorDrawableResourceId: Int
    ): BitmapDescriptor? {
        val background = ContextCompat.getDrawable(context, R.drawable.marker_background)
        background!!.setBounds(0, 0, background.intrinsicWidth, background.intrinsicHeight)
        val vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId)
        vectorDrawable!!.setBounds(
            0,
            0,
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight
        )
        val bitmap = Bitmap.createBitmap(
            background.intrinsicWidth,
            background.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        background.draw(canvas)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

}