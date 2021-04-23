package com.ajws.aquajoss.data.remote

import com.ajws.aquajoss.data.remote.model.LoginRequestDto
import com.ajws.aquajoss.data.remote.model.UserDetailsResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationService {
    @POST("auth/local")
    suspend fun login(@Body loginRequestDto: LoginRequestDto): Response<UserDetailsResponseDto>
}