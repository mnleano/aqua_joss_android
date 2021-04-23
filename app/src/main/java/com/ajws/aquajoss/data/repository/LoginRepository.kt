package com.ajws.aquajoss.data.repository

import com.ajws.aquajoss.data.maps.asLoginRequestDto
import com.ajws.aquajoss.data.remote.AuthenticationService
import com.ajws.aquajoss.data.views.LoginView

class LoginRepository(
    private val service: AuthenticationService
) {

    suspend fun login(loginView: LoginView) =
        service.login(loginView.asLoginRequestDto())
}