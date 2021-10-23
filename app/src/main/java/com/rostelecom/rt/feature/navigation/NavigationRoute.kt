package com.rostelecom.rt.feature.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rostelecom.rt.R

sealed class NavigationRoute(val route:String){
    object Welcome : NavigationRoute("welcome_screen")
    object Main : NavigationRoute("main_screen"){
        open class NavMainRoute(route: String, @StringRes val resourceId: Int, @DrawableRes val iconRes: Int) : NavigationRoute(route)
        object Profile: NavMainRoute("profile_screen" , R.string.profile, R.drawable.ic_profile)
        object Map: NavMainRoute("map_screen", R.string.map , R.drawable.ic_map)
        object Chat: NavMainRoute("chat_screen", R.string.chat, R.drawable.ic_chat)
        val items = listOf(
            Map, Chat , Profile
        )
    }
    object CreateRouteMap : NavigationRoute("create_route_screen")
}
