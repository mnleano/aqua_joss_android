package com.ajws.aquajoss.data.remote

import com.ajws.aquajoss.data.local.AccountPrefStore
import okhttp3.Interceptor
import okhttp3.Response

class BearerInterceptor(private val accountPrefStore: AccountPrefStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        if (!accountPrefStore.accessToken.isNullOrEmpty()) {
            chain.proceed(
                chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + accountPrefStore.accessToken)
                    .build()
            )
        } else {
            chain.proceed(chain.request())
        }
}