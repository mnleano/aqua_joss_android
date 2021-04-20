package com.ajws.aquajoss.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.entities.Product
import com.ajws.aquajoss.data.view.ProductView
import com.ajws.aquajoss.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initViews()

        return binding.root
    }

    private fun initViews() {

        val products = mutableListOf<ProductView>()
        products.add(ProductView(0, "Product 1", "Simple Description", 10.00, 100))
        products.add(ProductView(0, "Product 2", "Simple Description", 20.00, 100))
        products.add(ProductView(0, "Product 3", "Simple Description", 30.00, 100))
        products.add(ProductView(0, "Product 4", "Simple Description", 40.00, 100))
        products.add(ProductView(0, "Product 5", "Simple Description", 50.00, 100))
        products.add(ProductView(0, "Product 6", "Simple Description", 60.00, 100))
        products.add(ProductView(0, "Product 7", "Simple Description", 70.00, 100))

        binding.recyclerView.adapter = ProductAdapter(products)
    }
}