package com.rostelecom.rt.feature.navigation

import androidx.annotation.StringRes
import com.rostelecom.rt.R

sealed class NavigationRoute(val route:String){
    object Welcome : NavigationRoute("welcome_screen")
    object Main : NavigationRoute("main_screen"){
        open class NavMainRoute(route: String, @StringRes val resourceId: Int) : NavigationRoute(route)
        object Profile: NavMainRoute("profile_screen" , R.string.profile)
        object Map: NavigationRoute("map_screen")
        object Chat: NavigationRoute("chat_screen")
        val items = listOf(
            Map, Chat , Profile
        )
    }
}
