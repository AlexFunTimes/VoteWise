package com.votewise.app.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.votewise.app.R  // Assume icons in res/drawable

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        Screen.Home,  // "onboarding" or home dashboard
        Screen.Search,
        Screen.Matches,
        Screen.Profile
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = screen.icon), contentDescription = null) },
                label = { Text(screen.title) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

// Define sealed class for screens
sealed class Screen(val route: String, val title: String, val icon: Int) {
    object Home : Screen("onboarding", "Home", R.drawable.ic_home)
    object Search : Screen("search", "Search", R.drawable.ic_search)
    object Matches : Screen("matches", "Matches", R.drawable.ic_matches)
    object Profile : Screen("profile", "Profile", R.drawable.ic_profile)
}