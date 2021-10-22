package com.rostelecom.rt.feature.navigation

import androidx.annotation.StringRes

sealed class NavigationRoute(val route:String){
    object Welcome : NavigationRoute("welcome_screen")
    object Main : NavigationRoute("main_screen"){
        private class Ma(route: String,@StringRes val resourceId: Int) : NavigationRoute(route)
        object Profile: NavigationRoute("profile_screen")
        object Map: NavigationRoute("map_screen")
        object Chat: NavigationRoute("chat_screen")
    }
}
