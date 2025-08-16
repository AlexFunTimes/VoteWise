package com.votewise.app.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.votewise.app.ui.navigation.BottomNavBar

@Composable
fun MatchesScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomNavBar(navController) }) { padding ->
        LazyColumn(contentPadding = padding) {
            // List candidates with match %
            item { Text("Your Matches") }
        }
    }
}