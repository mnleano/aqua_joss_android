package com.ajws.aquajoss.data.manager

import com.ajws.aquajoss.data.entities.*
import com.ajws.aquajoss.data.maps.toCartEntity
import com.ajws.aquajoss.data.maps.toEntity
import com.ajws.aquajoss.data.views.OrderHistoryView
import com.ajws.aquajoss.data.views.ProductView
import com.ajws.aquajoss.util.Lg
import io.objectbox.Box

class DatabaseManager(
    private val cartProductBox: Box<CartProduct>,
    private val orderHistoryBox: Box<OrderHistory>,
    private val orderProductBox: Box<OrderProduct>,
    private val userBox: Box<User>
) {

    fun getCartProducts(): MutableList<CartProduct> = cartProductBox.all

    fun addCartProduct(productView: ProductView) {
        val product = getCartProduct(productView.productId)?.apply { this.quantity += 1 }
        Lg.d("addProduct: product=$product, productView=$productView")
        cartProductBox.put(product ?: productView.toCartEntity())
    }

    fun clearCart() =
        cartProductBox.removeAll()


    private fun getCartProduct(productId: Long): CartProduct? {
        Lg.d("getProduct: productId=$productId")
        return cartProductBox.query().equal(CartProduct_.productId, productId).build().findFirst()
    }

    fun putUser(user: User) = userBox.put(user)
    fun getUser(): User? = userBox.all.firstOrNull()

    fun getOrderHistories(): MutableList<OrderHistory> = orderHistoryBox.all

    fun addOrderHistory(orderHistoryView: OrderHistoryView) {
        val orderHistory = getOrderHistory(orderHistoryView.orderId)
        orderHistoryBox.put(orderHistory ?: orderHistoryView.toEntity())
    }

    fun addOrderProduct(orderProduct: OrderProduct) =
        orderProductBox.put(orderProduct)

    private fun getOrderHistory(orderId: Long): OrderHistory? {
        Lg.d("getOrderHistory: orderId=$orderId")
        return orderHistoryBox.query().equal(OrderHistory_.orderId, orderId).build().findFirst()
    }

    fun clear() {
        cartProductBox.removeAll()
        orderHistoryBox.removeAll()
        orderProductBox.removeAll()
        userBox.removeAll()
    }

}