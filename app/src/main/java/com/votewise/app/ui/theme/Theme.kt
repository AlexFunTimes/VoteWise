// ui/theme/Theme.kt
@Composable
fun VoteWiseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = dynamicColorScheme(), // Material You
        content = content
    )
}

// ui/screens/OnboardingScreen.kt (package com.votewise.app.ui.screens)
@Composable
fun OnboardingScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Welcome to VoteWise")
        TextField(value = "", onValueChange = {}, label = { Text("Enter ZIP Code") })
        Button(onClick = { navController.navigate("quiz") }) { Text("Start Quiz") }
        // X OAuth login button (use X SDK or WebView for auth)
    }
}

// ui/screens/QuizScreen.kt
@Composable
fun QuizScreen() {
    // 20-30 questions, e.g., LazyColumn with RadioButtons for issues
    // Compute match % using simple algorithm or AI call
    // Save to Room for caching
}

// ui/screens/CandidateReportScreen.kt
@Composable
fun CandidateReportScreen(candidateId: String) {
    val viewModel: CandidateViewModel = viewModel()
    val candidate = viewModel.getCandidate(candidateId).collectAsState(initial = null)

    TabRow(/* Tabs: Overview, Consistency, Donors, News */) {
        // Overview: Text(candidate.bio)
        // Consistency: AI score bar (ProgressIndicator)
        // Donors: PieChart using MPAndroidChart Compose wrapper
        // News: List of articles from NewsAPI, X semantic summaries
        // Voting: List from VoteSmart
    }
    // Pull data via ViewModel with Retrofit calls, cache in Room
}

// Navigation
@Composable
fun NavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "onboarding") {
        composable("onboarding") { OnboardingScreen(navController) }
        composable("quiz") { QuizScreen() }
        composable("search") { /* Search bar with autocomplete */ }
        composable("report/{candidateId}") { backStackEntry ->
            CandidateReportScreen(backStackEntry.arguments?.getString("candidateId")!!)
        }
        // Bottom nav: Home, Search, Matches, Profile
    }
}