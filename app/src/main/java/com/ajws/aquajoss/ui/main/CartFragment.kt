package com.ajws.aquajoss.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    private val products = mutableListOf<CartProductView>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)

        initViews()
        total()

        return binding.root
    }

    private fun initViews() {

//        products.add(CartProductView("PRODUCT ID 1", "Product Name 1", "Simple Description", 10.00, 9))
//        products.add(CartProductView("PRODUCT ID 1", "Product Name 2", "Simple Description", 13.00, 9))
//        products.add(CartProductView("PRODUCT ID 1", "Product Name 3", "Simple Description", 11.00, 9))
//        products.add(CartProductView("PRODUCT ID 1", "Product Name 4", "Simple Description", 11.00, 9))
//        products.add(CartProductView("PRODUCT ID 1", "Product Name 5", "Simple Description", 342.00, 9))
//        products.add(CartProductView(0, "Product 1", "Simple Description", 10.00, 6))
//        products.add(CartProductView(0, "Product 1", "Simple Description", 20.00, 2))
        binding.recyclerView.adapter = CartProductAdapter(products)
    }

    private fun total(){
        val totalAmount : Double = products.map {it.price * it.quantity}.sum()
        binding.tvTotal.text = String.format("%.2f",totalAmount)
    }
}