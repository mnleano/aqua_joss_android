package com.ajws.aquajoss.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.local.AccountPrefStore
import com.ajws.aquajoss.ui.intro.IntroActivity
import com.ajws.aquajoss.ui.main.MainActivity
import org.koin.android.ext.android.inject

class SplashScreenActivity : AppCompatActivity() {

    private val prefStore: AccountPrefStore by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(
                    this,
                    if (prefStore.isLoggedIn) MainActivity::class.java
                    else IntroActivity::class.java
                )
            )
            finish()
        }, 500)
    }
}