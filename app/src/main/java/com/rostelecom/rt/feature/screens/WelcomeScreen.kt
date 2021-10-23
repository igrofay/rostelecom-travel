package com.rostelecom.rt.feature.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.rostelecom.rt.R
import com.rostelecom.rt.feature.navigation.NavigationRoute


@Composable
fun WelcomeScreen(nav:NavController) {
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painterResource(R.drawable.background_welcome), contentDescription = null,
            Modifier
                .fillMaxHeight()
                .alpha(0.7f), contentScale = ContentScale.Crop)
        Image(painterResource(R.drawable.ic_logo), "LogoApp" ,
            Modifier.fillMaxSize(0.6f).clickable { nav.navigate(NavigationRoute.Main.route) }, )

    }
}



