package com.ajws.aquajoss.data.remote

import androidx.lifecycle.LiveData
import com.ajws.aquajoss.data.remote.model.LoginRequestDto
import com.ajws.aquajoss.data.remote.model.UserDetailsDto
import com.ajws.aquajoss.data.utils.ApiResponse
import retrofit2.http.POST

interface AuthenticationService {
    @POST("auth/local")
    suspend fun login(loginRequestDto: LoginRequestDto): LiveData<ApiResponse<UserDetailsDto>>
}