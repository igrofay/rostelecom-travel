package com.rostelecom.rt.ui.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.ui.theme.Gray200
import com.rostelecom.rt.ui.theme.Orange
import com.rostelecom.rt.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonGo(iconResource: Int, stringResourceButton: Int ) {
    var click by remember { mutableStateOf(false) }
    Surface(
        onClick = { click=! click},
        shape = Shapes.medium,
        border = BorderStroke(1.dp , Gray200),
        color = MaterialTheme.colors.surface
    ) {
        Row(modifier = Modifier.padding(
            start = 12.dp,
            end = 16.dp,
            top = 12.dp,
            bottom = 12.dp
        ).animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(painterResource(iconResource), contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(stringResource(stringResourceButton))
            if(click){
                Spacer(Modifier.width(16.dp))
                CircularProgressIndicator(Modifier.size(16.dp), strokeWidth = 2.dp,
                    color = MaterialTheme.colors.Orange)
            }
        }
    }
}