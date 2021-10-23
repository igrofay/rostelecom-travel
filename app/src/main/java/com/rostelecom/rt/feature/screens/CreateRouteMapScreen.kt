package com.rostelecom.rt.feature.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rostelecom.rt.feature.navigation.NavigationRoute
import com.rostelecom.rt.ui.theme.Orange
import com.rostelecom.rt.ui.theme.WhileOrBlack

@Preview
@Composable
fun CreateRouteMapScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("ddd") }
            ,backgroundColor = MaterialTheme.colors.Orange,
            contentColor = MaterialTheme.colors.WhileOrBlack)}
    ) {

    }
}