package com.ajws.aquajoss.data.views

data class CartProductView(
    val productId: Long,
    val productName: String,
    val description: String,
    val price: Double,
    val quantity: Int
)
{
    fun price() = "₱ ${String.format("%.2f", price)}"
}