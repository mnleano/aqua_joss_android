package com.ajws.aquajoss.data.entities

import io.objectbox.annotation.Id
import java.util.*

data class Order(
    @Id var id: Long = 0,
    var orderId: String,
    var orderStatus: Int,
    var deliveryAddress: String,
    var deliveryDate: Date?,
    var cancelledDate: Date?
)
