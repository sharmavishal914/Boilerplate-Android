package com.vishal.androidboilerplater.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import com.vishal.androidboilerplater.ui.base.BaseActivity
import com.vishal.androidboilerplater.ui.authentication.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    override fun onResume() {
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            overridePendingTransition(0, 0)
        }, 2000)
        super.onResume()
    }
}