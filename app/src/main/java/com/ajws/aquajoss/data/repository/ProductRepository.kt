package com.ajws.aquajoss.data.repository

import com.ajws.aquajoss.data.enums.OrderStatus
import com.ajws.aquajoss.data.manager.DatabaseManager
import com.ajws.aquajoss.data.maps.asView
import com.ajws.aquajoss.data.maps.toCartView
import com.ajws.aquajoss.data.maps.toOrderProductEntity
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.data.views.OrderHistoryView
import com.ajws.aquajoss.data.views.ProductView
import java.util.*

class ProductRepository(private val dbManager: DatabaseManager) {

    fun addProduct(productView: ProductView) {
        dbManager.addCartProduct(productView)
    }

    fun getCartProducts(): List<CartProductView> =
        dbManager.getCartProducts().map { it.toCartView() }

    fun confirmOrder(cartProducts: List<CartProductView>, total: Double) {
        val orderHistory = OrderHistoryView(
            System.currentTimeMillis(),
            total,
            OrderStatus.Processing,
            Date(),
            Date()
        )

        dbManager.clearCart()
        dbManager.addOrderHistory(orderHistory)
        cartProducts.forEach { cartProduct ->
            dbManager.addOrderProduct(
                cartProduct.toOrderProductEntity(orderHistory.orderId)
            )
        }
    }

    fun getOrderHistories(): List<OrderHistoryView> =
        dbManager.getOrderHistories().map { it.asView() }
}