package com.pietrantuono.myapplication.presentation

import com.pietrantuono.myapplication.data.network.Movie

sealed class UiState {
    data object Loading : UiState()

    data class Success(val movies: List<Movie> = emptyList()) : UiState()

    data class Error(val message: String = "") : UiState()
}
