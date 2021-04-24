package com.ajws.aquajoss.ui.intro

import android.content.Intent
import com.ajws.aquajoss.ui.BaseActivity
import com.ajws.aquajoss.ui.main.MainActivity

open class IntroBaseActivity : BaseActivity() {

    fun startLoginActivity(finishedActivity: Boolean = true) {
        startActivity(Intent(this, LoginActivity::class.java))
        if (finishedActivity) finish()
    }

    fun startSignUpActivity(finishedActivity: Boolean = true) {
        startActivity(Intent(this, SignUpActivity::class.java))
        if (finishedActivity) finish()
    }

    fun startMainActivity(){
        startClearTaskActivity(Intent(this, MainActivity::class.java))
    }
}