package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Id

data class User(
    @Id var id: Long = 0,
    var userId: Long,
    var fullName: String,
    var phoneNumber: String,
    var emailAddress: String,
    var address: String
)