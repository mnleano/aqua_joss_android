package com.ajws.aquajoss.ui.intro

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ajws.aquajoss.R
import com.ajws.aquajoss.databinding.ActivityIntroBinding

class IntroActivity : IntroBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityIntroBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_intro)

        binding.btnLogin.setOnClickListener { startLoginActivity(false) }
        binding.btnSignUp.setOnClickListener { startSignUpActivity(false) }
    }
}