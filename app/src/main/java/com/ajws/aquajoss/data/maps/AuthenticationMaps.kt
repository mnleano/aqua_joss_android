package com.ajws.aquajoss.data.maps

import com.ajws.aquajoss.data.remote.model.LoginRequestDto
import com.ajws.aquajoss.data.views.LoginView

fun LoginView.asLoginRequestDto(): LoginRequestDto =
    LoginRequestDto(
        this.identifier,
        this.password
    )