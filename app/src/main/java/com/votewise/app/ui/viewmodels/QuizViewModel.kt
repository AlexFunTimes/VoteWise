package com.votewise.app.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.votewise.app.data.models.Question
import com.votewise.app.data.repositories.CandidateRepository
import com.votewise.app.utils.PremiumManager
import kotlin.math.abs

// QuizViewModel: Manages quiz state, user answers, and candidate matching logic.
// Injected with CandidateRepository for data fetching.
// Uses Compose state for reactivity in UI.

class QuizViewModel(private val candidateRepo: CandidateRepository) : ViewModel() {
    val questions = mutableStateOf(listOf<Question>())  // List of quiz questions
    val userAnswers = mutableStateOf(mutableMapOf<Int, Int>())  // Question ID to answer index (0-4)
    val currentQuestionIndex = mutableStateOf(0)
    val isPremium = mutableStateOf(PremiumManager.isSubscribed())  // Subscription check

    init {
        loadQuestions()  // Load on initialization
    }

    private fun loadQuestions() {
        questions.value = if (isPremium.value) getExtendedQuestions() else getBasicQuestions().take(10)
    }

    fun submitAnswer(questionId: Int, answerIndex: Int) {
        userAnswers.value[questionId] = answerIndex
    }

    // Calculate match percentages with candidates
    fun calculateMatches(userLocation: String): Map<String, Int> {  // Candidate ID to match %
        val candidates = candidateRepo.getCandidatesForLocation(userLocation)
        val matches = mutableMapOf<String, Int>()
        candidates.forEach { candidate ->
            val score = computeMatchScore(candidate.positions, userAnswers.value)  // Compare positions
            matches[candidate.id] = score
        }
        return matches
    }

    private fun computeMatchScore(candidatePositions: Map<Int, Int>, userAnswers: Map<Int, Int>): Int {
        var totalDiff = 0
        userAnswers.forEach { (qId, userAns) ->
            val candAns = candidatePositions[qId] ?: 2  // Default neutral if no position
            totalDiff += abs(userAns - candAns)
        }
        return if (userAnswers.isNotEmpty()) 100 - (totalDiff * 100 / (userAnswers.size * 4)) else 0  // Normalize to %
    }

    // Placeholder for basic questions (hardcoded for MVP)
    private fun getBasicQuestions(): List<Question> {
        return listOf(
            Question(1, "Support higher taxes on wealthy?", "Economy"),
            Question(2, "Favor universal healthcare?", "Healthcare"),
            // Add 20-30 basic questions
        )
    }

    // Placeholder for extended questions (premium)
    private fun getExtendedQuestions(): List<Question> {
        return getBasicQuestions() + listOf(
            Question(21, "Stricter gun control laws?", "Social"),
            // Add more for 50+ total in premium
        )
    }
}