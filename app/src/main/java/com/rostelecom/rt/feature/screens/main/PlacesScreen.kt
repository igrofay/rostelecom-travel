package com.rostelecom.rt.feature.screens.main


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.ui.widgets.ButtonPlaces


@Composable
fun PlacesScreen() {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
        item {
            ButtonPlaces("Краснодарский край" ,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Krasnodar_teatr.jpg/1280px-Krasnodar_teatr.jpg")
        }
    }
}