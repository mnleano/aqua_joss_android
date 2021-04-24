package com.ajws.aquajoss.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.ajws.aquajoss.data.SingleEvent
import com.ajws.aquajoss.data.repository.ProductRepository
import com.ajws.aquajoss.data.views.CartProductView
import com.ajws.aquajoss.data.views.OrderHistoryView
import com.ajws.aquajoss.data.views.ProductView

class ProductViewModel(private val repository: ProductRepository) : BaseViewModel() {

    private val mCartProducts = MutableLiveData<List<CartProductView>>()
    val cartProducts: LiveData<List<CartProductView>> = mCartProducts

    private val mTotal = MediatorLiveData<Double>()
    val total: LiveData<Double> = mTotal

    private val mCheckOutClickEvent = MutableLiveData<SingleEvent<Unit>>()
    val checkOutClickEvent: LiveData<SingleEvent<Unit>> = mCheckOutClickEvent

    private val mConfirmOrderSuccessfulEvent = MutableLiveData<SingleEvent<Unit>>()
    val confirmOrderSuccessfulEvent: LiveData<SingleEvent<Unit>> = mConfirmOrderSuccessfulEvent

    init {
        mTotal.addSource(cartProducts) { products ->
            mTotal.postValue(products.map { product -> product.price * product.quantity }.sum())
        }
    }

    fun getCartProducts() =
        mCartProducts.postValue(repository.getCartProducts())

    fun addProduct(productView: ProductView) = repository.addProduct(productView)

    fun checkOutClickEvent() = mCheckOutClickEvent.postValue(SingleEvent(Unit))

    fun confirmOrderEvent() {
        repository.confirmOrder(cartProducts.value!!, total.value!!)
        mConfirmOrderSuccessfulEvent.postValue(SingleEvent(Unit))
    }

}