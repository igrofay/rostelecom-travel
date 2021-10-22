package com.rostelecom.rt.feature.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WelcomeScreen() {
    var visible by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .weight(1f)
                .clickable {
                    visible = !visible
                },
            contentAlignment = Alignment.Center
            ) {
            Image(painterResource(R.drawable.background_welcome), contentDescription = null,
                Modifier
                    .fillMaxHeight()
                    .alpha(0.5f), contentScale = ContentScale.FillHeight)
            Image(painterResource(R.drawable.ic_logo), "LogoApp" ,
                Modifier.fillMaxSize(0.6f), )
        }
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(),
            exit = shrinkVertically(),
            modifier = Modifier.weight(2f)
        ){

        }
    }
}

@Composable
fun SignInOrUp() {
    Column(modifier = Modifier.fillMaxSize()){
        Row(Modifier.fillMaxWidth()) {
            TextButton(
                onClick = { /*TODO*/ },
                Modifier.weight(1f)
            ) {

            }
            TextButton(
                onClick = { /*TODO*/ },
                Modifier.weight(1f)
            ) {

            }
        }
    }
}


