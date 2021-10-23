package com.rostelecom.rt.ui.widgets


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.rostelecom.rt.ui.theme.WhileOrBlack

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

@Composable
fun EditTextBasic(text: String, hint: String, onValNew: (new: String) -> Unit){
    Box {
        Text(hint , style = MaterialTheme.typography.subtitle2)
        BasicTextField(value = text, onValueChange = onValNew ,
            textStyle = MaterialTheme.typography.subtitle2 ,
            modifier = Modifier.background( if(text.isEmpty())  Color.Transparent else MaterialTheme.colors.WhileOrBlack ))
    }

}