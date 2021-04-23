package com.ajws.aquajoss.data.views

data class ProductView(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int
) {
    fun price() = "₱ ${String.format("%.2f", price)}"
}