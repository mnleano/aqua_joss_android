package com.ajws.aquajoss.data.maps

import com.ajws.aquajoss.data.entities.CartProduct
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.data.views.ProductView

fun ProductView.toCartEntity() =
    CartProduct(
        0,
        this.productId,
        this.productName,
        this.description,
        this.price,
        1
    )

fun CartProduct.toCartView() =
    CartProductView(
        this.productId,
        this.productName,
        this.description,
        this.price,
        this.quantity
    )