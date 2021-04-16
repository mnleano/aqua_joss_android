package com.ajws.aquajoss.data.manager

import com.ajws.aquajoss.data.entities.Order
import com.ajws.aquajoss.data.entities.Product
import com.ajws.aquajoss.data.entities.ProductOrder
import io.objectbox.Box

class DatabaseManager(
    private val orderBox: Box<Order>,
    private val productBox: Box<Product>,
    private val productOrderBox: Box<ProductOrder>
) {


}