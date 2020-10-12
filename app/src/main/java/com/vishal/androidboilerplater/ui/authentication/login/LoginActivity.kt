package com.vishal.androidboilerplater.ui.authentication.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.vishal.androidboilerplater.R
import com.vishal.androidboilerplater.databinding.ActivityLoginBinding
import com.vishal.androidboilerplater.ui.base.BaseActivity
import com.vishal.androidboilerplater.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(this, { _ ->
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
//            if (result is ApiResult.Success) {
//                showSnackBar(result.data.ip)
//            } else if (result is ApiResult.Faliour) {
//                showSnackBar(result.exception.message.toString())
//            }
        })
    }

    private fun initialize() {
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_login
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setActivityTitle(getString(R.string.login))

        binding.btnLogin.setOnClickListener {
            viewModel.login()
        }
    }

    override fun onBackPressed() {
        if (!(viewModel.isLoading.value as Boolean))
            super.onBackPressed()
    }

}