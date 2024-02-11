package com.pietrantuono.myapplication.data

import com.pietrantuono.myapplication.data.network.Movies

interface ApiClient {
    suspend fun getPopularMovies(
        language: String = EN_US,
        page: Int = FIRST_PAGE,
    ): Movies

    private companion object {
        private const val EN_US = "en-US"
        private const val FIRST_PAGE = 1
    }
}
