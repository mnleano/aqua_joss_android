package com.ajws.aquajoss.data.manager

import com.ajws.aquajoss.data.entities.OrderHistory
import com.ajws.aquajoss.data.entities.CartProduct
import com.ajws.aquajoss.data.entities.OrderProduct
import io.objectbox.Box

class DatabaseManager(
    private val cartProductBox: Box<CartProduct>,
    private val orderHistoryBox: Box<OrderHistory>,
    private val orderProductBox: Box<OrderProduct>
) {


}