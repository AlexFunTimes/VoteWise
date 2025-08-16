package com.votewise.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import BillingManager
import com.votewise.app.ui.navigation.NavGraph  // Import the nav graph
import com.votewise.app.ui.theme.Theme as VoteWiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var billingManager: BillingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        billingManager = BillingManager(this)
        setContent {
            VoteWiseTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavGraph()  // Use NavGraph which contains NavHost
                }
            }
        }
    }
}