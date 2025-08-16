package com.votewise.app.data.viewmodel

import androidx.lifecycle.ViewModel
import com.votewise.app.data.repositories.CandidateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CandidateViewModel @Inject constructor(private val repository: CandidateRepository) : ViewModel() {
    // Flows for data
}