package com.ajws.aquajoss.data.manager

import com.ajws.aquajoss.data.entities.OrderHistory
import com.ajws.aquajoss.data.entities.CartProduct
import io.objectbox.Box

class DatabaseManager(
    private val orderBox: Box<OrderHistory>,
    private val productOrderBox: Box<CartProduct>
) {


}