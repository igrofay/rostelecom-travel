package com.rostelecom.rt.feature.screens.maproutes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.Black900
import com.rostelecom.rt.ui.theme.Gray200
import com.rostelecom.rt.ui.theme.Shapes
import com.rostelecom.rt.ui.widgets.EditTextBasic

@Composable
fun SettingRouteScreen() {
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
        item { AtoB() }
    }


}

@Composable
fun AtoB() {
    var placesStart by remember{
        mutableStateOf("")
    }
    var placesEnd by remember{
        mutableStateOf("")
    }
    Surface(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp , Black900),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
            Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.spacedBy(4.dp)){
                Image(painterResource(R.drawable.ic_route), contentDescription = null , modifier = Modifier.size(40.dp))
                Text(stringResource(R.string.where_going), style = MaterialTheme.typography.subtitle1
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()) {
                Icon(painterResource(R.drawable.ic_start), contentDescription = null )
                EditTextBasic(placesStart, "Откуда ?" ){ placesStart = it }
            }
        }
    }
}