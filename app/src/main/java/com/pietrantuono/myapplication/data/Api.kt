package com.pietrantuono.myapplication.data

import com.pietrantuono.myapplication.data.network.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int,
    ): Movies
}
