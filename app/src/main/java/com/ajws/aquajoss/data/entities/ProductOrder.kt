package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class ProductOrder(
    @Id var id: Long = 0,
    var orderId: String,
    var productId: String,
    var name: String,
    var description: String,
    var price: Double,
    var quantity: Int
)
