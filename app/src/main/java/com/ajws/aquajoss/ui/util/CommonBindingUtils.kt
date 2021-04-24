package com.ajws.aquajoss.ui.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.enums.OrderStatus
import com.ajws.aquajoss.util.DateUtility
import com.ajws.aquajoss.util.getColorById
import java.util.*

@BindingAdapter("orderStatus")
fun TextView.setOrderStatus(status: OrderStatus?) =
    status?.let {
        val context = this.context
        this.text = context.getString(it.status)
        this.setTextColor(context.getColorById(it.colorId))
    }

@BindingAdapter("orderLastUpdate")
fun TextView.setOrderLastUpdate(date: Date?) =
    date?.let { this.text = DateUtility.getDateOnlyFormattedString(date) }

@BindingAdapter("orderAmount")
fun TextView.setOrderAmount(amount: Double?) =
    amount?.let {
        val text = "₱ ${String.format("%.2f", amount)}"
        this.text = text
    }

@BindingAdapter("productImage")
fun ImageView.setProductImage(productId: Long?) =
    productId?.let { id ->
        this.setImageDrawable(
            ContextCompat.getDrawable(
                this.context,
                when (id) {
                    1619251670000 -> R.drawable.product_five_galon_round
                    1619251671000 -> R.drawable.product_five_galon_slim
                    else -> R.drawable.product_plastic_bottle
                }
            )
        )
    }

@BindingAdapter("amount")
fun TextView.setPrice(amount: Double?) =
    amount?.let { a ->
        val text = "₱ ${String.format("%.2f", a)}"
        this.text = text
    }

@BindingAdapter("orderId")
fun TextView.setOrderId(orderId: Long?) =
    orderId?.let { id ->
        val text = "Order Id# $orderId"
        this.text = text

    }