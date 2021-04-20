package com.ajws.aquajoss.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.view.ProductView
import com.ajws.aquajoss.databinding.RowProductBinding

class ProductAdapter(private val products: MutableList<ProductView>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(val binding: RowProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(RowProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.binding.data = product
        holder.binding.root.setOnClickListener {

        }
        holder.binding.ivAddToCart.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = products.size
}