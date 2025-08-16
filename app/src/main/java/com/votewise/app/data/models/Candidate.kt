// File: app/src/main/java/com/example/votewise/data/models/Candidate.kt
// Define Candidate model for repository
package com.votewise.app.data.models

data class Candidate(
    val id: String,
    val name: String,
    val positions: Map<Int, Int>  // Question ID to position index (0-4)
)