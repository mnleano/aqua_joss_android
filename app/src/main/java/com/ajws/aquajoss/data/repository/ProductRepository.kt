package com.ajws.aquajoss.data.repository

import com.ajws.aquajoss.data.manager.DatabaseManager
import com.ajws.aquajoss.data.views.ProductView

class ProductRepository(private val dbManager: DatabaseManager) {

    fun addProduct(productView: ProductView) {
        dbManager.addProduct(productView)
    }

}