package com.ajws.aquajoss.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ajws.aquajoss.data.remote.model.UserDetailsResponseDto
import com.ajws.aquajoss.data.repository.LoginRepository
import com.ajws.aquajoss.data.views.LoginView
import com.ajws.aquajoss.util.Lg
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val mUserDetails = MutableLiveData<UserDetailsResponseDto>()
    val userDetails: LiveData<UserDetailsResponseDto> = mUserDetails

    fun login() {
        val username = username.value
        val password = password.value
        if (username == null || password == null)
            return

        viewModelScope.launch {
            mLoading.postValue(true)
            repository.login(LoginView(username, password)).let { response ->
                mLoading.postValue(false)
                response.body()?.let { userDetails ->
                    mUserDetails.postValue(userDetails)
                } ?: mErrorMessage.postValue(response.errorBody().toString())
                Lg.d("login: body=${response.body()}")
                Lg.d("login: errorBody=${response.errorBody()}")

            }
        }
    }
}