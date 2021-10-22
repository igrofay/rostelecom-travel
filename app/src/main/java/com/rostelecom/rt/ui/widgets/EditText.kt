package com.rostelecom.rt.ui.widgets


import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun EditText(iconResource: Int , stringResourceLabel: Int ) {
    var input by remember { mutableStateOf("") }
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        label = { Text(stringResource(stringResourceLabel)) },
        leadingIcon = { Icon(painterResource(iconResource), contentDescription = null)}
    )
}

@Composable
fun EditTextPassword(iconResource: Int , stringResourceLabel: Int ) {
    var input by remember { mutableStateOf("") }
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        label = { Text(stringResource(stringResourceLabel)) },
        leadingIcon = { Icon(painterResource(iconResource), contentDescription = null)}
    )
}