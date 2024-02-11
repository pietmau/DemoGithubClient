package com.pietrantuono.myapplication.di

import com.pietrantuono.myapplication.data.ApiClient
import com.pietrantuono.myapplication.data.AuthInterceptor
import com.pietrantuono.myapplication.data.RetrofitApiClient
import com.pietrantuono.myapplication.domain.MoviesRepository
import com.pietrantuono.myapplication.domain.RetrofitMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(ViewModelComponent::class)
interface MoviesModule {
    @Binds
    fun bindRepository(moviesRepository: RetrofitMoviesRepository): MoviesRepository

    @Binds
    fun bindInterceptor(interceptor: AuthInterceptor): Interceptor

    companion object {
        @Provides
        fun provideCoroutineContext(): CoroutineContext = Dispatchers.Main

        @Provides
        fun bindApiClient(interceptor: Interceptor): ApiClient =
            RetrofitApiClient(
                coroutineContext = Dispatchers.IO,
                interceptor = interceptor,
            )
    }
}
