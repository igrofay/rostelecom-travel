package com.rostelecom.rt.feature.navigation

sealed class NavigationRoute(route:String){
    object Welcome : NavigationRoute("welcome_screen")
    object Main : NavigationRoute("main_screen")
}
