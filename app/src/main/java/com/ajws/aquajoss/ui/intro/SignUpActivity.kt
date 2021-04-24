package com.ajws.aquajoss.ui.intro

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.SignUpViewModel
import com.ajws.aquajoss.databinding.ActivitySignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : IntroBaseActivity() {

    private val vm: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignUpBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.lifecycleOwner = this
        binding.vm = vm

        vm.registerSuccessfulEvent.observe(this, { startMainActivity() })
        vm.loginClickEvent.observe(this, { startLoginActivity()})
    }
}