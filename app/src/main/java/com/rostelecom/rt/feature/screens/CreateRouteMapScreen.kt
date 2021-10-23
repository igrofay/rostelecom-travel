package com.rostelecom.rt.feature.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rostelecom.rt.feature.navigation.NavigationRoute
import com.rostelecom.rt.ui.theme.Orange
import com.rostelecom.rt.ui.theme.WhileOrBlack


@Composable
fun CreateRouteMapScreen(navHostControllerApp: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                Spacer(Modifier.width(8.dp))
                Icon(Icons.Default.ArrowBack, "", Modifier.clickable { navHostControllerApp.popBackStack() })
            },
                title = { Text("ddd") }
            ,backgroundColor = MaterialTheme.colors.Orange,
            contentColor = MaterialTheme.colors.WhileOrBlack)}
    ) {

    }
}