package com.pietrantuono.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pietrantuono.myapplication.domain.MoviesUseCase
import com.pietrantuono.myapplication.presentation.UiState.Error
import com.pietrantuono.myapplication.presentation.UiState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainViewModel
    @Inject
    constructor(
        private val moviesUseCase: MoviesUseCase,
        coroutineContext: CoroutineContext,
    ) : ViewModel() {
        val uiState: Flow<UiState>
            get() = _uiState

        private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)

        init {
            viewModelScope.launch(coroutineContext) {
                moviesUseCase.invoke().collect { result ->
                    result.onSuccess {
                        _uiState.tryEmit(Success(it.results))
                    }.onFailure {
                        _uiState.tryEmit(Error(it.message ?: ""))
                    }
                }
            }
        }
    }
