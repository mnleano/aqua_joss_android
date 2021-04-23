package com.ajws.aquajoss.data.repository

import com.ajws.aquajoss.data.entities.User
import com.ajws.aquajoss.data.local.AccountPrefStore
import com.ajws.aquajoss.data.manager.DatabaseManager
import com.ajws.aquajoss.data.maps.asLoginRequestDto
import com.ajws.aquajoss.data.remote.AuthenticationService
import com.ajws.aquajoss.data.views.LoginView
import com.ajws.aquajoss.data.views.SignUpView

class AuthenticationRepository(
    private val service: AuthenticationService,
    private val dbManager: DatabaseManager,
    private val prefStore: AccountPrefStore
) {

    suspend fun login(loginView: LoginView) =
        service.login(loginView.asLoginRequestDto())

    fun saveUser() {
        prefStore.isLoggedIn = true
        dbManager.putUser(
            User(
                0,
                System.currentTimeMillis(),
                "Full Name",
                "09123456789",
                "sample@email.abc",
                "123 Sample St. Mock Address, For Testing"
            )
        )
    }

    fun saveUser(signUpView: SignUpView) {
        prefStore.isLoggedIn = true
        dbManager.putUser(
            User(
                0,
                System.currentTimeMillis(),
                signUpView.fullName,
                signUpView.phoneNumber,
                signUpView.emailAddress,
                signUpView.address
            )
        )
    }
}