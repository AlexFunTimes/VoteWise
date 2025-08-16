package com.votewise.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun OnboardingScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to VoteWise", style = MaterialTheme.typography.headlineLarge)
        var zipCode by remember { mutableStateOf("") }
        TextField(
            value = zipCode,
            onValueChange = { zipCode = it },
            label = { Text("Enter ZIP Code") }
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("quiz") }) {
            Text("Start Quiz")
        }
    }
}