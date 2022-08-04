package com.example.data.interceptors

import com.example.data.managers.TokenManager
import com.example.domain.gateways.UserGateway
import dagger.Lazy
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class RefreshTokenInterceptor @Inject constructor(
    private val userGateway: Lazy<UserGateway>,
    private val tokenManager: TokenManager,
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request {
        userGateway.get().refreshAccessToken(tokenManager.refreshToken).map { tokenManager.login(it) }.blockingGet()
        return response.request.newBuilder()
            .header("Authorization", "Bearer " + tokenManager.accessToken)
            .build()
    }
}
