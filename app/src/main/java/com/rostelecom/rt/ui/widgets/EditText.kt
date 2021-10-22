package com.rostelecom.rt.ui.widgets


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun EditText(@DrawableRes iconResource: Int ,@StringRes stringResourceLabel: Int ) {
    var input by remember { mutableStateOf("") }
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        label = { Text(stringResource(stringResourceLabel)) },
        leadingIcon = { Icon(painterResource(iconResource), contentDescription = null)}
    )
}

@Composable
fun EditTextPassword(@DrawableRes iconResource: Int ,@StringRes stringResourceLabel: Int ) {
    var input by remember { mutableStateOf("") }
    OutlinedTextField(
        value = input,
        onValueChange = { input = it },
        label = { Text(stringResource(stringResourceLabel)) },
        leadingIcon = { Icon(painterResource(iconResource), contentDescription = null)}
    )
}