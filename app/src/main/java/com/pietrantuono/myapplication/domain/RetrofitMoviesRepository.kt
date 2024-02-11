package com.pietrantuono.myapplication.domain

import com.pietrantuono.myapplication.data.ApiClient
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RetrofitMoviesRepository
    @Inject
    constructor(
        private val apiClient: ApiClient,
    ) : MoviesRepository {
        override fun getPopularMovies(
            language: String,
            page: Int,
        ) = flow {
            emit(runCatching { apiClient.getPopularMovies(language, page) })
        }
    }
