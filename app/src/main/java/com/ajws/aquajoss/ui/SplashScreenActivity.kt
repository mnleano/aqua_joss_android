package com.ajws.aquajoss.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajws.aquajoss.R
import com.ajws.aquajoss.ui.intro.IntroActivity
import com.ajws.aquajoss.ui.intro.SignUpActivity
import com.ajws.aquajoss.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startActivity(Intent(this, IntroActivity::class.java))
        finish()
    }
}