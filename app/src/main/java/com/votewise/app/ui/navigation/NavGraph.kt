package com.votewise.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.votewise.app.ui.screens.CandidateReportScreen
import com.votewise.app.ui.screens.MatchesScreen
import com.votewise.app.ui.screens.OnboardingScreen
import com.votewise.app.ui.screens.ProfileScreen
import com.votewise.app.ui.screens.QuizScreen
import com.votewise.app.ui.screens.SearchScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "onboarding") {
        composable("onboarding") { OnboardingScreen(navController) }
        composable("quiz") { QuizScreen(navController) }
        composable("search") { SearchScreen(navController) }
        composable("matches") { MatchesScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("report/{candidateId}") { backStackEntry ->
            CandidateReportScreen(
                candidateId = backStackEntry.arguments?.getString("candidateId") ?: "",
                navController = navController
            )
        }
    }
    // Integrate with BottomNavBar at the bottom of screens or as a scaffold
}