package com.rostelecom.rt.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rostelecom.rt.feature.screens.WelcomeScreen

@Composable
fun NavigationAppRT(navHost: NavHostController) {
    NavHost(navController = navHost, startDestination = NavigationRoute.Welcome.route){
        composable(NavigationRoute.Welcome.route){ WelcomeScreen()}
    }

}