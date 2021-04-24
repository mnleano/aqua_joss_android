package com.ajws.aquajoss.data.manager

import com.ajws.aquajoss.data.entities.*
import com.ajws.aquajoss.data.maps.toCartEntity
import com.ajws.aquajoss.data.views.ProductView
import com.ajws.aquajoss.util.Lg
import io.objectbox.Box

class DatabaseManager(
    private val cartProductBox: Box<CartProduct>,
    private val orderHistoryBox: Box<OrderHistory>,
    private val orderProductBox: Box<OrderProduct>,
    private val userBox: Box<User>
) {

    fun getProducts(): MutableList<CartProduct> = cartProductBox.all

    fun addProduct(productView: ProductView) {
        val product = getProduct(productView.productId)?.apply { this.quantity += 1 }
        Lg.d("addProduct: product=$product, productView=$productView")
        cartProductBox.put(product ?: productView.toCartEntity())
    }

    private fun getProduct(productId: Long): CartProduct? {
        Lg.d("getProduct: productId=$productId")
        return cartProductBox.query().equal(CartProduct_.productId, productId).build().findFirst()
    }

    fun putUser(user: User) = userBox.put(user)
    fun getUser(): User? = userBox.all.firstOrNull()

    fun clear() {
        cartProductBox.removeAll()
        orderHistoryBox.removeAll()
        orderProductBox.removeAll()
        userBox.removeAll()
    }

}