package com.votewise.app.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.votewise.app.ui.viewmodels.QuizViewModel

@Composable
fun QuizScreen(navController: NavController) {
    val viewModel: QuizViewModel = hiltViewModel()
    LazyColumn {
        // Questions from viewModel
        item { Text("Quiz Question 1") }
        // Radio buttons, on complete navigate to "matches"
    }
}