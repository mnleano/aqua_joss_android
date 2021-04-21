package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Id

data class OrderProduct(
    @Id var id: Long = 0,
    var orderId: String,
    var productId: String,
    var productName: String,
    var description: String,
    var price: Double,
    var quantity: Int
)
