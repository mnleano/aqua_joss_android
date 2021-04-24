package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class CartProduct(
    @Id var id: Long = 0,
    var productId: Long,
    var productName: String,
    var description: String,
    var price: Double,
    var quantity: Int
)
