package com.pietrantuono.myapplication.domain

import com.pietrantuono.myapplication.data.network.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getPopularMovies(
        language: String = EN_US,
        page: Int = FIRST_PAGE,
    ): Flow<Result<Movies>>

    private companion object {
        private const val EN_US = "en-US"
        private const val FIRST_PAGE = 1
    }
}
