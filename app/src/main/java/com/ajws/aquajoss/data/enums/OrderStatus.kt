package com.ajws.aquajoss.data.enums

import com.ajws.aquajoss.R

enum class OrderStatus(val status: Int, val colorId: Int) {
    Processing(R.string.order_status_processing, R.color.order_status_processing),
    Canceled(R.string.order_status_canceled, R.color.order_status_canceled),
    OutForDelivery(R.string.order_status_out_for_delivery, R.color.order_status_out_for_delivery),
    OnItsWay(R.string.order_status_on_its_way, R.color.order_status_on_its_way),
    Delivered(R.string.order_status_delivered, R.color.order_status_delivered)
}