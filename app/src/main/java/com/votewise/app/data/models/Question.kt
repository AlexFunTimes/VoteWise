package com.votewise.app.data.models

data class Question(
    val id: Int,
    val text: String,
    val category: String,  // e.g., "Economy"
    val options: List<String> = listOf("Strongly Disagree", "Disagree", "Neutral", "Agree", "Strongly Agree")
)