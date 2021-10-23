package com.rostelecom.rt.feature.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rostelecom.rt.R
import com.rostelecom.rt.ui.theme.Gray200
import com.rostelecom.rt.ui.theme.Gray700
import com.rostelecom.rt.ui.theme.Purple500
import com.rostelecom.rt.ui.widgets.ButtonGo
import com.rostelecom.rt.ui.widgets.EditText
import com.rostelecom.rt.ui.widgets.EditTextPassword

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
                Text(
                    stringResource(R.string.sign_in) ,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = if(isSign) Purple500 else Gray700
                )
            }
            TextButton(
                onClick = {

                },
                Modifier.weight(1f)
            ) {
                Text(
                    stringResource(R.string.sign_up),
                    style = MaterialTheme.typography.subtitle1 ,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = if(!isSign) Purple500 else Gray700
                )
            }
        }
        if (isSign) SignIn()
    }
}

@Composable
fun SignIn() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditText(R.drawable.ic_email, R.string.email)
        EditTextPassword(R.drawable.ic_lock , R.string.password)
        ButtonGo(R.drawable.ic_run , R.string.come_in)
    }
}
