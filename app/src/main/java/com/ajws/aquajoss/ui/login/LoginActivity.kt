package com.ajws.aquajoss.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.LoginViewModel
import com.ajws.aquajoss.databinding.ActivityLoginBinding
import com.ajws.aquajoss.util.Lg
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val vm: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.lifecycleOwner = this
        binding.vm = vm

        vm.userDetails.observe(this, { result ->
            Lg.d("loggedInResult=$result")
        })

        vm.errorMessage.observe(this, { errorMessage ->
            Lg.d("errorMessage=$errorMessage")
        })
    }
}