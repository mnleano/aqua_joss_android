package com.ajws.aquajoss.data.manager

import com.ajws.aquajoss.data.entities.OrderHistory
import com.ajws.aquajoss.data.entities.CartProduct
import com.ajws.aquajoss.data.entities.OrderProduct
import com.ajws.aquajoss.data.entities.User
import io.objectbox.Box

class DatabaseManager(
    private val cartProductBox: Box<CartProduct>,
    private val orderHistoryBox: Box<OrderHistory>,
    private val orderProductBox: Box<OrderProduct>,
    private val userBox: Box<User>
) {

    fun putUser(user: User) = userBox.put(user)

    fun getUser(): User? = userBox.query().build().findFirst()

    fun clear(){
        cartProductBox.removeAll()
        orderHistoryBox.removeAll()
        orderProductBox.removeAll()
        userBox.removeAll()
    }

}