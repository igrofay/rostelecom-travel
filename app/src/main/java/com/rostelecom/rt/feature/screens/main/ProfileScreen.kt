package com.rostelecom.rt.feature.screens.main

import com.rostelecom.rt.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.ui.theme.Orange
import com.rostelecom.rt.ui.theme.Orange500
import com.rostelecom.rt.ui.theme.Purple
import com.rostelecom.rt.ui.theme.Teal

@Preview
@Composable
fun ProfileScreen() {
   LazyColumn{
       item {
           val sweep = Brush.verticalGradient(
               listOf(MaterialTheme.colors.Purple,
                   MaterialTheme.colors.Orange))
           Column(
               Modifier
                   .fillMaxWidth()
                   .height(200.dp)
                   .background(sweep, alpha = 0.7f)
                   .padding(16.dp),
           ) {
               Image(painter = painterResource(R.drawable.ic_person), contentDescription = "Profile",
                   Modifier
                       .size(110.dp)
                       .clip(CircleShape)
               )
               Spacer(Modifier.height(8.dp))
               Text(stringResource(R.string.user), style = MaterialTheme.typography.h6 , color = Color.White)
               Spacer(Modifier.height(4.dp))
               Text(stringResource(R.string.email), color = Color.White)
           }
       }
   }
}