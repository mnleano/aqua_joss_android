package com.ajws.aquajoss.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajws.aquajoss.data.view.CartProductView
import com.ajws.aquajoss.databinding.RowCartBinding

class CartProductAdapter( private val products: MutableList<CartProductView>) :
    RecyclerView.Adapter<CartProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: RowCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.binding.data = product
        holder.binding.root.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = products.size
}