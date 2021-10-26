package com.rostelecom.rt.module

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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

class WorkMaps(var googleMap: GoogleMap, var pointsList: List<List<Double>>) {

    var gpsTracker = GPSTracker(App.appContext)

    init {
        startLogic()
    }

    private fun startLogic() {

        val context = App.appContext

        googleMap.uiSettings.apply {
            isZoomControlsEnabled = false
            isMapToolbarEnabled = false
            isCompassEnabled = false
        }

        if (context.isDarkThemeOn()) {
            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(App.appContext, R.raw.map_style))
        }

        val pos = LatLng(0.0, 0.0)
        googleMap.addMarker(MarkerOptions().position(pos))
//        moveCamera(LatLng(gpsTracker.getLatitude(), gpsTracker.getLongitude()))

        addPolyline()

    }

    fun Context.isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
    }

    private fun moveCamera(latLng: LatLng) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
    }



    private fun addPolyline() {
        val polylineOptions = PolylineOptions()
            .color(Color.RED)
            .geodesic(false)
            .width(13f)
            .jointType(JointType.BEVEL)
            .clickable(true)

        pointsList.forEach {
            polylineOptions.add(LatLng(it[0], it[1]))
        }

        googleMap.addPolyline(polylineOptions)

        moveCamera(LatLng(pointsList[0][0], pointsList[0][1]))

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