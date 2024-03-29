package com.rostelecom.rt.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rostelecom.rt.feature.main.ViewModelMain
import com.rostelecom.rt.feature.screens.*
import com.rostelecom.rt.feature.screens.main.*
import com.rostelecom.rt.feature.screens.maproutes.MapRoutesScreen

@Composable
fun NavigationAppRT(navHost: NavHostController,  model: ViewModelMain) {
    NavHost(navController = navHost, startDestination = NavigationRoute.Welcome.route){
        composable(NavigationRoute.Welcome.route){ WelcomeScreen(navHost)}
        composable(NavigationRoute.Main.route){ MainScreen(navHost , model ) }
    }
}

@Composable
fun NavigationMain( navHostMain: NavHostController, innerPadding : PaddingValues , model: ViewModelMain) {
    NavHost(navHostMain, startDestination = NavigationRoute.Main.MapRoutes.route, Modifier.padding(innerPadding)) {
        composable(NavigationRoute.Main.MapRoutes.route) { MapRoutesScreen(model) }
        composable(NavigationRoute.Main.Chat.route) { ChatScreen() }
        composable(NavigationRoute.Main.Profile.route){ ProfileScreen() }
        composable(NavigationRoute.Main.Places.route){ PlacesScreen(model) }
    }
}

