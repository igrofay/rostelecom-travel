package com.rostelecom.rt.feature.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.rostelecom.rt.R



@Preview
@Composable
fun WelcomeScreen() {
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
            Modifier.fillMaxSize(0.6f), )

    }
}



