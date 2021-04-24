package com.ajws.aquajoss.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ajws.aquajoss.data.SingleEvent
import com.ajws.aquajoss.data.repository.AuthenticationRepository
import com.ajws.aquajoss.data.views.SignUpView

class SignUpViewModel(private val repository: AuthenticationRepository) : BaseViewModel() {

    val fullName = MutableLiveData<String>()
    val birthday = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()
    val emailAddress = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    private val mLoginClickEvent = MutableLiveData<SingleEvent<Unit>>()
    val loginClickEvent: LiveData<SingleEvent<Unit>> = mLoginClickEvent

    private val mRegisterSuccessfulEvent = MutableLiveData<SingleEvent<Unit>>()
    val registerSuccessfulEvent: LiveData<SingleEvent<Unit>> = mRegisterSuccessfulEvent

    fun register() {

        val fullName = fullName.value
        val birthday = birthday.value
        val phoneNumber = phoneNumber.value
        val emailAddress = emailAddress.value
        val address = address.value
        val password = password.value
        val confirmPassword = confirmPassword.value

        if (fullName.isNullOrEmpty() ||
            birthday.isNullOrEmpty() ||
            phoneNumber.isNullOrEmpty() ||
            emailAddress.isNullOrEmpty() ||
            address.isNullOrEmpty() ||
            password.isNullOrEmpty() ||
            confirmPassword.isNullOrEmpty()
        ) return

        val signUpView =
            SignUpView(fullName, birthday, phoneNumber, emailAddress, address, password)

        repository.saveUser(signUpView)
        mRegisterSuccessfulEvent.postValue(SingleEvent(Unit))
    }

    fun loginClickEvent() = mLoginClickEvent.postValue(SingleEvent(Unit))

}