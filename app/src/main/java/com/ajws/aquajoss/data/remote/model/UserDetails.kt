package com.ajws.aquajoss.data.remote.model


import com.google.gson.annotations.SerializedName

data class UserDetails(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("orders")
    val orders: List<Any>,
    @SerializedName("secret_answer")
    val secretAnswer: String,
    @SerializedName("secret_question")
    val secretQuestion: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String
)