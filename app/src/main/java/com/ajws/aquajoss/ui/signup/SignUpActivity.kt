package com.ajws.aquajoss.ui.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ajws.aquajoss.R
import com.ajws.aquajoss.data.viewModels.SignUpViewModel
import com.ajws.aquajoss.databinding.ActivitySignUpBinding
import com.ajws.aquajoss.ui.BaseActivity
import com.ajws.aquajoss.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity() {

    private val vm: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignUpBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.lifecycleOwner = this
        binding.vm = vm

        vm.registerSuccessfulEvent.observe(this, {
            startClearTaskActivity(Intent(this, MainActivity::class.java))
        })
    }
}