package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Id
import java.util.*

data class OrderHistory(
    @Id var id: Long = 0,
    var orderId: String,
    var orderStatus: Int,
    var orderDate: Date,
    var lastModifiedDate: Date,
    var totalAmount: Double
)
