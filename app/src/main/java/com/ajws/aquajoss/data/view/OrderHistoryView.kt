package com.ajws.aquajoss.data.view

import com.ajws.aquajoss.data.enums.OrderStatus
import java.util.*

data class OrderHistoryView(
    val orderId: String,
    val orderStatus: OrderStatus,
    val orderDate: Date,
    val lastModifiedDate: Date,
    val totalAmount: Double
)