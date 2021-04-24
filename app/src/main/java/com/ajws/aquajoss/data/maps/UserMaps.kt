package com.ajws.aquajoss.data.maps

import com.ajws.aquajoss.data.entities.User
import com.ajws.aquajoss.data.remote.model.UserDetails
import com.ajws.aquajoss.data.remote.model.UserDetailsResponseDto
import com.ajws.aquajoss.data.views.SignUpView
import com.ajws.aquajoss.data.views.UserView

fun User.asView() =
    UserView(
        this.fullName,
        this.phoneNumber,
        this.emailAddress,
        this.address
    )