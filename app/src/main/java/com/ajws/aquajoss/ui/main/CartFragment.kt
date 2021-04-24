package com.ajws.aquajoss.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.ProductViewModel
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.databinding.FragmentCartBinding
import com.ajws.aquajoss.ui.widget.DialogUtil
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    private val vm: ProductViewModel by viewModel()
    private val products = mutableListOf<CartProductView>()
    private lateinit var adapter: CartProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        vm.getCartProducts()

        initViews()
        observeData()

        return binding.root
    }

    private fun initViews() {
        adapter = CartProductAdapter(products)
        binding.recyclerView.adapter = adapter
    }

    private fun observeData() {
        binding.lifecycleOwner = this
        binding.vm = vm

        vm.cartProducts.observe(viewLifecycleOwner, {
            products.clear()
            products.addAll(it)
            adapter.notifyDataSetChanged()
        })

        vm.checkOutClickEvent.observe(viewLifecycleOwner, {

        })

        vm.confirmOrderSuccessfulEvent.observe(viewLifecycleOwner, {
            DialogUtil.show(requireActivity(),
                "Order Successful",
                getString(R.string.ok),
                { dialog, _ ->
                    vm.getCartProducts()
                    dialog.dismiss()
                })
        })
    }
}