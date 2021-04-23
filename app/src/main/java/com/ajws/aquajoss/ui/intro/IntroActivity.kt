package com.ajws.aquajoss.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ajws.aquajoss.R
import com.ajws.aquajoss.databinding.ActivityIntroBinding
import com.ajws.aquajoss.ui.login.LoginActivity
import com.ajws.aquajoss.ui.signup.SignUpActivity

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityIntroBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_intro)

        binding.btnLogin.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )
        }
        binding.btnSignUp.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SignUpActivity::class.java
                )
            )
        }
    }
}