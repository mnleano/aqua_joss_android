package com.ajws.aquajoss.ui.intro

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.LoginViewModel
import com.ajws.aquajoss.databinding.ActivityLoginBinding
import com.ajws.aquajoss.ui.widget.DialogUtil
import com.ajws.aquajoss.util.Lg
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : IntroBaseActivity() {

    private val vm: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.lifecycleOwner = this
        binding.vm = vm

        vm.signUpClickEvent.observe(this, { startSignUpActivity() })

        vm.loginSuccessfulEvent.observe(this, { startMainActivity() })

        vm.errorMessage.observe(this, { errorMessage ->
            Lg.d("errorMessage=$errorMessage")
            DialogUtil.show(this,
                errorMessage,
                getString(R.string.retry),
                { dialog, _ ->
                    vm.retry()
                    dialog.dismiss()
                })
        })


    }
}