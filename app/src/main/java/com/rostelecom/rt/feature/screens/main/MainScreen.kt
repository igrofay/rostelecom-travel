package com.rostelecom.rt.feature.screens.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rostelecom.rt.feature.main.ViewModelMain
import com.rostelecom.rt.feature.navigation.BottomNavigationMain
import com.rostelecom.rt.feature.navigation.NavigationMain
import com.rostelecom.rt.feature.navigation.NavigationRoute

@Composable
fun MainScreen(navHostControllerApp: NavHostController , model: ViewModelMain) {
    val navControllerMain = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationMain(navControllerMain, NavigationRoute.Main.items)
        }
    ) { innerPadding ->
        NavigationMain( navControllerMain, innerPadding , model )
    }
}