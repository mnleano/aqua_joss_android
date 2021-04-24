package com.ajws.aquajoss.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.databinding.RowCartBinding

class CartProductAdapter(private val cartProducts: MutableList<CartProductView>) :
    RecyclerView.Adapter<CartProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: RowCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartProduct = cartProducts[position]
        holder.binding.data = cartProduct
        holder.binding.root.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = cartProducts.size
}