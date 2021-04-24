package com.ajws.aquajoss.data.views

import android.graphics.drawable.Drawable

data class ProductView(
    val productId: Long,
    val productName: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val drawable: Drawable?,
) {
    fun price() = "₱ ${String.format("%.2f", price)}"
}