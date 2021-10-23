package com.rostelecom.rt.feature.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rostelecom.rt.R

sealed class NavigationRoute(val route:String){
    object Welcome : NavigationRoute("welcome_screen")
    object Main : NavigationRoute("main_screen"){
        open class NavMainRoute(route: String, @StringRes val resourceId: Int, @DrawableRes val iconRes: Int) : NavigationRoute(route)
        object Profile: NavMainRoute("profile_screen" , R.string.profile, R.drawable.ic_profile)
        object MapRoutes: NavMainRoute("map_routes_screen", R.string.routes , R.drawable.ic_map_routes){
            object SettingRoute : NavigationRoute("setting_route_map_screen")
            object ListRoutesMap : NavigationRoute("list_routes_map_screen")
            object Map : NavigationRoute("map_screen")
        }
        object Places : NavMainRoute("places_screen", R.string.places , R.drawable.ic_place)
        object Chat: NavMainRoute("chat_screen", R.string.chat, R.drawable.ic_chat)
        val items = listOf(
            MapRoutes, Places ,Chat , Profile
        )

    }

}
