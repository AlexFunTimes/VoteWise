package com.votewise.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.votewise.app.ui.navigation.BottomNavBar

@Composable
fun SearchScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomNavBar(navController) }) { padding ->
        Column(Modifier.padding(padding)) {
            TextField(value = "", onValueChange = {}, label = { Text("Search Candidates") })
            // Add list/grid of results; integrate repository fetches
        }
    }
}