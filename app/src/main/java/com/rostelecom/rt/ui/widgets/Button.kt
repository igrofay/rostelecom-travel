package com.rostelecom.rt.ui.widgets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.TransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.*
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonGo(@DrawableRes iconResource: Int,@StringRes stringResourceButton: Int ) {
    var click by remember { mutableStateOf(false) }
    Surface(
        onClick = { click=! click},
        shape = Shapes.medium,
        border = BorderStroke(1.dp , Gray200),
        color = MaterialTheme.colors.surface
    ) {
        Row(modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
            .animateContentSize(
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonPlaces(labelText: String, urlImage: String){
    Surface(
        onClick = { },
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp , Gray200),
        color = MaterialTheme.colors.surface
    ){
        Box(
            Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {

            GlideImage(imageModel = urlImage, error = Icons.Default.Face,
                modifier = Modifier
                    .fillMaxSize()
                    , contentScale = ContentScale.Crop)
            Box(Modifier.fillMaxSize().alpha(0.7f).background(Color.Black))
            Text(labelText, Modifier.align(Alignment.Center), textAlign = TextAlign.Center ,
                style = MaterialTheme.typography.h4, fontWeight = FontWeight.W700,
                fontFamily = FontFamily.SansSerif, color = Color.White,  overflow = TextOverflow.Ellipsis)

        }
    }

}


