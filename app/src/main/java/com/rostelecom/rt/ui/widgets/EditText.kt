package com.rostelecom.rt.ui.widgets


import android.icu.lang.UCharacter
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.rostelecom.rt.ui.theme.BlackOrWhile
import com.rostelecom.rt.ui.theme.WhileOrBlack

@Composable
fun EditText(@DrawableRes iconResource: Int ,@StringRes stringResourceLabel: Int , typeInput : KeyboardType,
             input : String , newInput : (value : String) -> Unit ) {

    OutlinedTextField( modifier = Modifier.fillMaxWidth(),
        value = input,
        onValueChange = newInput,
        label = { Text(stringResource(stringResourceLabel)) },
        leadingIcon = { Icon(painterResource(iconResource), contentDescription = null)},
        singleLine = true , keyboardOptions = KeyboardOptions(keyboardType = typeInput)
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
fun EditTextBasic(text: String, @StringRes hint: Int, onValNew: (new: String) -> Unit){
    Box {
        if(text.isEmpty()) Text(stringResource(hint) , fontSize = MaterialTheme.typography.h6.fontSize)
        BasicTextField(value = text, onValueChange = onValNew ,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.h6.fontSize,
                color = MaterialTheme.colors.BlackOrWhile
            ), singleLine = true  , cursorBrush = SolidColor(MaterialTheme.colors.BlackOrWhile)
        )
    }

}