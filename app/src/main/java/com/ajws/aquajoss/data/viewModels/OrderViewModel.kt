package com.ajws.aquajoss.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.ajws.aquajoss.data.SingleEvent
import com.ajws.aquajoss.data.repository.ProductRepository
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.data.views.OrderHistoryView
import com.ajws.aquajoss.data.views.ProductView

class OrderViewModel(private val repository: ProductRepository) : BaseViewModel() {

    private val mOrderHistories = MutableLiveData<List<OrderHistoryView>>()
    val orderHistories: LiveData<List<OrderHistoryView>> = mOrderHistories

    fun getOrderHistories() =
        mOrderHistories.postValue(repository.getOrderHistories())
}