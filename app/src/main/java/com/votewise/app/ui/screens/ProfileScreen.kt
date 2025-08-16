package com.votewise.app.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.votewise.app.ui.navigation.BottomNavBar

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomNavBar(navController) }) { padding ->
        Text("Profile Settings", modifier = Modifier.padding(padding))
        // Add X login, preferences
    }
}