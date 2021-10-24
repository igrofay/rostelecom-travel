package com.rostelecom.rt.feature.screens.maproutes

import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rostelecom.rt.feature.main.ViewModelMain
import com.rostelecom.rt.feature.navigation.NavigationRoute
import com.rostelecom.rt.feature.screens.main.MapScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MapRoutesScreen(model: ViewModelMain) {
    val navMap = rememberNavController()
    var visible by remember {
        mutableStateOf(false)
    }
    Scaffold(
        Modifier.fillMaxSize(),
        floatingActionButton = {
            AnimatedVisibility(visible = visible,
                enter= fadeIn(),
            exit=  fadeOut()
            ) {
                FloatingActionButton(onClick = {
                    navMap.navigate(NavigationRoute.Main.MapRoutes.CreateRoute.route)
                     }) {
                    Icon(Icons.Default.Add, contentDescription = null )
                }
            }

        }
    ) {
        NavHost(navController = navMap, startDestination = NavigationRoute.Main.MapRoutes.ListRoutesMap.route){
            composable(NavigationRoute.Main.MapRoutes.ListRoutesMap.route){
                visible = true
                ListRoutesMapScreen() }
            composable(NavigationRoute.Main.MapRoutes.CreateRoute.route){
                visible = false
                CreateRouteScreen(navMap, model)
            }
            composable(NavigationRoute.Main.MapRoutes.Map.route){
                MapScreen()
            }
        }
    }
}