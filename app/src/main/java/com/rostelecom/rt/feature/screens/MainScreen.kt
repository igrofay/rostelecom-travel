package com.rostelecom.rt.feature.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rostelecom.rt.feature.navigation.BottomNavigationMain
import com.rostelecom.rt.feature.navigation.NavigationMain
import com.rostelecom.rt.feature.navigation.NavigationRoute

@Composable
fun MainScreen() {
    val navControllerMain = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationMain(navControllerMain, NavigationRoute.Main.items)
        }
    ) { innerPadding ->
        NavigationMain(navControllerMain, innerPadding )
    }
}


@Preview
@Composable
fun F(){
    MainScreen()
}