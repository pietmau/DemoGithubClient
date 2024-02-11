package com.pietrantuono.myapplication.data

import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RetrofitApiClient
    @Inject
    constructor(private val coroutineContext: CoroutineContext, private val interceptor: Interceptor) : ApiClient {
        private val api =
            Retrofit.Builder()
                .baseUrl(URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build(),
                )
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(Api::class.java)

        override suspend fun getPopularMovies(
            language: String,
            page: Int,
        ) = withContext(coroutineContext) { api.getPopularMovies(language, page) }

        private companion object {
            private const val URL = "https://api.themoviedb.org/3/"
        }
    }
