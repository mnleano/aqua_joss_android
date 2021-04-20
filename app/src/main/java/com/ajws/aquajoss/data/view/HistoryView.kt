package com.ajws.aquajoss.data.view

import com.ajws.aquajoss.data.enums.OrderStatus
import java.util.*

data class HistoryView(
    val productId: String,
    val productName: String,
    val orderStatus: OrderStatus,
    val lastModifiedDate: Date,
    val totalAmount: Double
)