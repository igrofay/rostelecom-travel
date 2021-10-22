package com.rostelecom.rt.feature.screens

import androidx.compose.animation.*
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.Gray200
import com.rostelecom.rt.ui.theme.Gray500
import com.rostelecom.rt.ui.theme.Purple500
import com.rostelecom.rt.ui.widgets.ButtonGo
import com.rostelecom.rt.ui.widgets.EditText
import com.rostelecom.rt.ui.widgets.EditTextPassword


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
                    .alpha(0.7f), contentScale = ContentScale.Crop)
            Image(painterResource(R.drawable.ic_logo), "LogoApp" ,
                Modifier.fillMaxSize(0.6f), )
        }
        AnimatedVisibility(
            visible = visible,
            enter = expandVertically(),
            exit = shrinkVertically(),
            modifier = Modifier.weight(2f)
        ){
            SignInOrUp()
        }
    }
}

@Composable
fun SignInOrUp() {
    var isSign by remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxSize()){
        Row(
            Modifier
                .fillMaxWidth()
                .background(Gray200)) {
            TextButton(
                onClick = {

                },
                Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.sign_in) ,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = if(isSign) Purple500 else Gray500
                )
            }
            TextButton(
                onClick = {

                          },
                Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.sign_up),
                    style = MaterialTheme.typography.subtitle1 ,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = if(!isSign) Purple500 else Gray500
                )
            }
        }
        if (isSign) SignIn()
    }
}

@Composable
fun SignIn() {
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditText(R.drawable.ic_email, R.string.email)
        EditTextPassword(R.drawable.ic_lock , R.string.password)
        ButtonGo(R.drawable.ic_run , R.string.come_in)
    }
}


