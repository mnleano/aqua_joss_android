package com.ajws.aquajoss.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.ProductViewModel
import com.ajws.aquajoss.data.views.ProductView
import com.ajws.aquajoss.databinding.FragmentHomeBinding
import com.ajws.aquajoss.util.Lg
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val vm: ProductViewModel by viewModel()

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
        products.add(
            ProductView(
                1619251670000,
                "5 Gallon Round Water Container",
                "Aqua Joss Purified Drinking Water is a quality yet affordable brand for daily consumption of clean, and safe bottled water",
                25.00,
                100,
                ContextCompat.getDrawable(requireActivity(), R.drawable.product_five_galon_round)
            )
        )
        products.add(
            ProductView(
                1619251671000,
                "5 Gallon Blue Slim Container with Handle",
                "Aqua Joss Purified Drinking Water is a quality yet affordable brand for daily consumption of clean, and safe bottled water",
                25.00,
                100,
                ContextCompat.getDrawable(requireActivity(), R.drawable.product_five_galon_slim)
            )
        )
        products.add(
            ProductView(
                1619251672000,
                "1000ml Distilled Water Bottle",
                "",
                20.00,
                100,
                ContextCompat.getDrawable(requireActivity(), R.drawable.product_plastic_bottle)
            )
        )
        products.add(
            ProductView(
                1619251673000,
                "500ml Distilled Water Bottle",
                "",
                15.00,
                100,
                ContextCompat.getDrawable(requireActivity(), R.drawable.product_plastic_bottle)
            )
        )
        products.add(
            ProductView(
                1619251674000,
                "3500ml Distilled Water Bottle",
                "",
                10.00,
                100,
                ContextCompat.getDrawable(requireActivity(), R.drawable.product_plastic_bottle)
            )
        )

        binding.recyclerView.adapter = ProductAdapter(products,
            object : ProductAdapter.ProductClickListener {
                override fun onProductClick(product: ProductView) {

                }

                override fun onProductAddToCart(product: ProductView) {
                    vm.addProduct(product)
                    Lg.d("onProductAddToCart: ${product.productName} added")
                }
            })
    }
}