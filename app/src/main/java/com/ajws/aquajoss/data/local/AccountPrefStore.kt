package com.ajws.aquajoss.data.local

class AccountPrefStore(private val prefs: LocalPreferences) {

    var isLoggedIn: Boolean
        get() = prefs.getBoolean(IS_LOGGED_IN, false)
        set(value) = prefs.putBoolean(IS_LOGGED_IN, value)

    var accessToken: String?
        get() = prefs.getString(ACCESS_TOKEN, "")
        set(value) = prefs.putString(ACCESS_TOKEN, value)

    companion object {
        private const val CLASS_NAME = "AccountPrefStore"
        private const val IS_LOGGED_IN = "$CLASS_NAME.isLoggedIn"
        private const val ACCESS_TOKEN = "$CLASS_NAME.accessToken"
    }
}