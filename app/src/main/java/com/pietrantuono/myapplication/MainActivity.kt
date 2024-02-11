package com.pietrantuono.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pietrantuono.myapplication.presentation.MainViewModel
import com.pietrantuono.myapplication.presentation.UiState.Loading
import com.pietrantuono.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = HOME,
                ) {
                    composable(HOME) {
                        val viewModel = hiltViewModel<MainViewModel>()
                        val uiState by viewModel.uiState.collectAsStateWithLifecycle(Loading)

                    }
                }
            }
        }
    }

    private companion object {
        private const val HOME = "home"
    }
}
