package com.rostelecom.rt.feature.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rostelecom.rt.ui.theme.WhileOrBlack
import com.rostelecom.rt.ui.widgets.BottomNavItem

@Composable
fun BottomNavigationMain(navHost: NavHostController, items: List<NavigationRoute.Main.NavMainRoute>) {
    Row(
        Modifier
            .shadow(8.dp)
            .background(MaterialTheme.colors.WhileOrBlack)
            .padding(8.dp)
            .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceAround) {
        val navBackStackEntry by navHost.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item->
            BottomNavItem(
                currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navHost.navigate(item.route) {
                        popUpTo(navHost.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                item.iconRes, item.resourceId
            )
        }
    }
}


