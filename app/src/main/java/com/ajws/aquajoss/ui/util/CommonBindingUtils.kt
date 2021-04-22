package com.ajws.aquajoss.ui.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
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
