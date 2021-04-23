package com.ajws.aquajoss.ui.orderHistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.enums.OrderStatus
import com.ajws.aquajoss.data.views.OrderHistoryView
import com.ajws.aquajoss.databinding.FragmentGenericListBinding
import java.util.*

class OrderHistoryFragment : Fragment() {

    private lateinit var binding: FragmentGenericListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGenericListBinding.inflate(inflater, container, false)
        binding.title.text = getString(R.string.navigation_order_history)
        observeData()

        return binding.root
    }

    private fun observeData(){

        val orderHistories = mutableListOf<OrderHistoryView>()
        orderHistories.add(OrderHistoryView("ORDER ID#1", 1000.0, OrderStatus.Canceled, Date(), Date()))
        orderHistories.add(OrderHistoryView("ORDER ID#2", 1200.0, OrderStatus.Canceled, Date(), Date()))
        orderHistories.add(OrderHistoryView("ORDER ID#3", 1030.0, OrderStatus.Canceled, Date(), Date()))
        orderHistories.add(OrderHistoryView("ORDER ID#4", 1050.0, OrderStatus.Canceled, Date(), Date()))
        orderHistories.add(OrderHistoryView("ORDER ID#5", 1010.0, OrderStatus.Canceled, Date(), Date()))
        orderHistories.add(OrderHistoryView("ORDER ID#6", 10.0, OrderStatus.Canceled, Date(), Date()))

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = OrderHistoryAdapter(orderHistories)
    }

}