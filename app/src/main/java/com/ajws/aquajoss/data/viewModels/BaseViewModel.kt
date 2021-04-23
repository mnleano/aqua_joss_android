package com.ajws.aquajoss.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    protected val mLoading = MediatorLiveData<Boolean>()
    val loading: LiveData<Boolean> = mLoading

    protected val mErrorMessage = MediatorLiveData<String>()
    val errorMessage: LiveData<String> = mErrorMessage
}