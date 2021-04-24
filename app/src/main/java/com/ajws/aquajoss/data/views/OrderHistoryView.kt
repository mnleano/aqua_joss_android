package com.ajws.aquajoss.data.views

import com.ajws.aquajoss.data.enums.OrderStatus
import java.util.*

data class OrderHistoryView(
    val orderId: Long,
    val orderAmount: Double,
    val orderStatus: OrderStatus,
    val orderDate: Date,
    val orderLastUpdate: Date
)