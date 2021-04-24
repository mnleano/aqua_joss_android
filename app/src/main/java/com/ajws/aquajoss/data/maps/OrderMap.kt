package com.ajws.aquajoss.data.maps

import com.ajws.aquajoss.data.entities.OrderHistory
import com.ajws.aquajoss.data.entities.OrderProduct
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.data.views.OrderHistoryView

fun OrderHistoryView.toEntity() =
    OrderHistory(
        0,
        this.orderId,
        this.orderAmount,
        this.orderStatus.ordinal,
        this.orderDate,
        this.orderLastUpdate
    )

fun CartProductView.toOrderProductEntity(orderId: Long) =
    OrderProduct(
        0,
        orderId,
        this.productId,
        this.productName,
        this.description,
        this.price,
        this.quantity
    )