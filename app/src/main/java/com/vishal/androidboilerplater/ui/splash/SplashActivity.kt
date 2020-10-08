package com.vishal.androidboilerplater.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.vishal.androidboilerplater.MyApplication
import com.vishal.androidboilerplater.R
import com.vishal.androidboilerplater.data.local.SessionManager
import com.vishal.androidboilerplater.ui.base.BaseActivity
import com.vishal.androidboilerplater.ui.home.HomeActivity
import com.vishal.androidboilerplater.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    override fun onResume() {
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        }, 2000)
        super.onResume()
    }
}