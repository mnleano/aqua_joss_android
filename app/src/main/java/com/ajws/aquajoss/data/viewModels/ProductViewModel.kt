package com.ajws.aquajoss.data.viewModels

import com.ajws.aquajoss.data.repository.ProductRepository
import com.ajws.aquajoss.data.views.ProductView

class ProductViewModel(private val repository: ProductRepository) : BaseViewModel() {

    fun addProduct(productView: ProductView) = repository.addProduct(productView)
}