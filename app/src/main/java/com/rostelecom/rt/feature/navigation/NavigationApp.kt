package com.rostelecom.rt.feature.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rostelecom.rt.feature.screens.*
import com.rostelecom.rt.feature.screens.main.ChatScreen
import com.rostelecom.rt.feature.screens.main.MainScreen
import com.rostelecom.rt.feature.screens.main.MapScreen
import com.rostelecom.rt.feature.screens.main.ProfileScreen

@Composable
fun NavigationAppRT(navHost: NavHostController) {
    NavHost(navController = navHost, startDestination = NavigationRoute.Welcome.route){
        composable(NavigationRoute.Welcome.route){ WelcomeScreen(navHost)}
        composable(NavigationRoute.Main.route){ MainScreen(navHost) }
        composable(NavigationRoute.CreateRouteMap.route){ CreateRouteMapScreen(navHost) }
    }
}

@Composable
fun NavigationMain(navHostControllerApp: NavHostController, navHostMain: NavHostController, innerPadding : PaddingValues ) {
    NavHost(navHostMain, startDestination = NavigationRoute.Main.Map.route, Modifier.padding(innerPadding)) {
        composable(NavigationRoute.Main.Map.route) { MapScreen(onClickCreateRoute = { navHostControllerApp.navigate(NavigationRoute.CreateRouteMap.route) }) }
        composable(NavigationRoute.Main.Chat.route) { ChatScreen() }
        composable(NavigationRoute.Main.Profile.route){ ProfileScreen() }
    }
}

