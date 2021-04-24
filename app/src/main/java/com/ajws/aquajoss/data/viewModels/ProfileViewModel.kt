package com.ajws.aquajoss.data.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ajws.aquajoss.data.SingleEvent
import com.ajws.aquajoss.data.repository.AuthenticationRepository
import com.ajws.aquajoss.data.views.UserView

class ProfileViewModel(private val repository: AuthenticationRepository) : BaseViewModel() {

    private val mUserView = MutableLiveData<UserView>()
    val userView: LiveData<UserView> = mUserView

    private val mAboutUsClickEvent = MutableLiveData<SingleEvent<Unit>>()
    val aboutUsClickEvent: LiveData<SingleEvent<Unit>> = mAboutUsClickEvent

    private val mLogOutClickEvent = MutableLiveData<SingleEvent<Unit>>()
    val logOutClickEvent: LiveData<SingleEvent<Unit>> = mLogOutClickEvent

    private val mLogOutSuccessfulEvent = MutableLiveData<SingleEvent<Unit>>()
    val logOutSuccessfulEvent: LiveData<SingleEvent<Unit>> = mLogOutSuccessfulEvent

    init {
        mUserView.postValue(repository.getUser())
    }

    fun aboutUsClickEvent() = mAboutUsClickEvent.postValue(SingleEvent(Unit))

    fun logOutClickEvent() = mLogOutClickEvent.postValue(SingleEvent(Unit))

    fun logOut() {
        repository.logOut()
        mLogOutSuccessfulEvent.postValue(SingleEvent(Unit))
    }
}