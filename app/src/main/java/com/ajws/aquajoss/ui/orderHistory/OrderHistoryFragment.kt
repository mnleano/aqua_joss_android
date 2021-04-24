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

    private fun observeData() {

        val orderHistories = mutableListOf<OrderHistoryView>()
        orderHistories.add(
            OrderHistoryView(
                1619259315526,
                1000.0,
                OrderStatus.Canceled,
                Date(1619259315526),
                Date(1619250015526)
            )
        )
        orderHistories.add(
            OrderHistoryView(
                1619259315527,
                1200.0,
                OrderStatus.OnItsWay,
                Date(1619259315526),
                Date(1619250125526)
            )
        )
        orderHistories.add(
            OrderHistoryView(
                1619259315528,
                1030.0,
                OrderStatus.Processing,
                Date(1619259315526),
                Date(1619250235526)
            )
        )
        orderHistories.add(
            OrderHistoryView(
                1619259315529,
                1050.0,
                OrderStatus.Delivered,
                Date(1619259315526),
                Date(1619250445526)
            )
        )
        orderHistories.add(
            OrderHistoryView(
                1619259315530,
                1010.0,
                OrderStatus.OutForDelivery,
                Date(1619259315526),
                Date(1619250655526)
            )
        )
        orderHistories.add(
            OrderHistoryView(
                1619259315531,
                10.0,
                OrderStatus.Processing,
                Date(1619259315526),
                Date(1619250865526)
            )
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = OrderHistoryAdapter(orderHistories)
    }

}