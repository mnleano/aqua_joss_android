package com.ajws.aquajoss.data.remote.model


import com.google.gson.annotations.SerializedName

data class UserDetailsDto(
    @SerializedName("jwt")
    val jwt: String,
    @SerializedName("user")
    val user: User
)