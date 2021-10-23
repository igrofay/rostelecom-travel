package com.rostelecom.rt.feature.screens.main

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.rostelecom.rt.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.libraries.maps.MapView
import com.google.maps.android.ktx.awaitMap
import com.rostelecom.rt.module.WorkMaps
import com.rostelecom.rt.ui.theme.Gray200
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun MapScreen(onClickCreateRoute: ()-> Unit ) {
    val mapView = rememberMapViewWithLifeCycle()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AndroidView({ mapView }) { mapView ->
            CoroutineScope(Dispatchers.Main).launch {
                val googleMap = mapView.awaitMap()
                val workMaps = WorkMaps(googleMap)
            }
        }
        Box(Modifier.padding(16.dp).clip(CircleShape).align(Alignment.BottomCenter).background(Gray200.copy(0.5f)).clickable(onClick = onClickCreateRoute)){
            Row(
                Modifier
                    .padding(12.dp)
                    , verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(painterResource(R.drawable.ic_route), contentDescription = null )
                Text(stringResource(R.string.where_going))
            }
        }

    }

}

@Composable
fun rememberMapViewWithLifeCycle(): MapView {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            id = com.google.maps.android.ktx.R.id.map_frame
        }
    }
    val lifeCycleObserver = rememberLifeCycleObserver(mapView)
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifeCycle) {
        lifeCycle.addObserver(lifeCycleObserver)
        onDispose {
            lifeCycle.removeObserver(lifeCycleObserver)
        }
    }
    return mapView
}

@Composable
fun rememberLifeCycleObserver(mapView: MapView): LifecycleEventObserver = remember(mapView) {
    LifecycleEventObserver { _, event ->
        when(event) {
            Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
            Lifecycle.Event.ON_START -> mapView.onStart()
            Lifecycle.Event.ON_RESUME -> mapView.onResume()
            Lifecycle.Event.ON_PAUSE -> mapView.onPause()
            Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
            Lifecycle.Event.ON_STOP -> mapView.onStop()
            else -> IllegalStateException()
        }
    }
}