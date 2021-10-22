package com.rostelecom.rt.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rostelecom.rt.feature.screens.*

@Composable
fun NavigationAppRT(navHost: NavHostController) {
    NavHost(navController = navHost, startDestination = NavigationRoute.Welcome.route){
        composable(NavigationRoute.Welcome.route){ WelcomeScreen()}
        composable(NavigationRoute.Main.route){ MainScreen() }
    }
}

@Composable
fun NavigationMain(navHost: NavHostController, innerPadding : PaddingValues ) {
    NavHost(navHost, startDestination = NavigationRoute.Main.Map.route, Modifier.padding(innerPadding)) {
        composable(NavigationRoute.Main.Map.route) { MapScreen() }
        composable(NavigationRoute.Main.Chat.route) { ChatScreen() }
        composable(NavigationRoute.Main.Profile.route){ ProfileScreen() }
    }
}