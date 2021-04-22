package com.ajws.aquajoss.ui.orderHistory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajws.aquajoss.data.view.OrderHistoryView
import com.ajws.aquajoss.databinding.RowOrderHistoryBinding

class OrderHistoryAdapter(private val orderHistories: MutableList<OrderHistoryView>) :
    RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RowOrderHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RowOrderHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderHistory = orderHistories[position]
        holder.binding.data = orderHistory
        holder.binding.root.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = orderHistories.size

}