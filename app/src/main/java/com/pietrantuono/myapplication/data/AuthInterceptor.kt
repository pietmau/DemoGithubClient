package com.pietrantuono.myapplication.data

import com.pietrantuono.myapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor
    @Inject
    constructor() : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request =
                chain.request()
                    .newBuilder()
                    .header(
                        name = AUTHORIZATION,
                        value = "$BEARER ${BuildConfig.API_KEY}",
                    )
                    .build()
            return chain.proceed(request)
        }

        private companion object {
            private const val AUTHORIZATION = "Authorization"
            private const val BEARER = "Bearer"
        }
    }
