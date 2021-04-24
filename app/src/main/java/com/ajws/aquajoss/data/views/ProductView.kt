package com.ajws.aquajoss.data.views

import android.graphics.drawable.Drawable

data class ProductView(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val drawable: Drawable?,
) {
    fun price() = "₱ ${String.format("%.2f", price)}"
}