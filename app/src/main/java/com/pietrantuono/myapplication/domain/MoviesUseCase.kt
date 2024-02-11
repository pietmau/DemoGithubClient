package com.pietrantuono.myapplication.domain

import javax.inject.Inject

class MoviesUseCase
    @Inject
    constructor(private val moviesRepository: MoviesRepository) {
        operator fun invoke() = moviesRepository.getPopularMovies()
    }
