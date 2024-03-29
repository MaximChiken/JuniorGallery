package com.example.data.interceptors

import com.example.data.managers.tokenmanager.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(private val tokenManager: TokenManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Authorization", "Bearer " + tokenManager.accessToken)
            .build()
        return chain.proceed(request)
    }
}