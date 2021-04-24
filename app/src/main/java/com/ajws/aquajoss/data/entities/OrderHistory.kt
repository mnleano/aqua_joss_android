package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class OrderHistory(
    @Id var id: Long = 0,
    var orderId: String,
    var orderAmount: Double,
    var orderStatus: Int,
    var orderDate: Date,
    var orderLastUpdate: Date,
)
