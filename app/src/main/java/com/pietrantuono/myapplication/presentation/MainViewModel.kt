package com.pietrantuono.myapplication.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val uiState: Flow<UiState>
        get() = _uiState

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
}