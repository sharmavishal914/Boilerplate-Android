package com.vishal.androidboilerplater.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vishal.androidboilerplater.data.ApiResult
import com.vishal.androidboilerplater.data.local.SessionManager
import com.vishal.androidboilerplater.data.remote.RequestInterface
import com.vishal.androidboilerplater.ui.login.model.LoginResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel @ViewModelInject constructor(
    val sessionManager: SessionManager,
    private val requestInterface: RequestInterface
) : ViewModel() {

    var tag = "Login"
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()
    val loginResult = MutableLiveData<ApiResult<LoginResult>>()

    init {
        email.value = ""
        password.value = ""
        isLoading.value = false
    }

    fun login() {
        isLoading.value = true
        @Suppress("UNUSED_VARIABLE")
        val disposable = requestInterface.getServiceIP()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<LoginResult>() {
                override fun onNext(t: LoginResult) {
                    loginResult.value = ApiResult.Success(t)
                    isLoading.value = false
                }

                override fun onError(e: Throwable) {
                    loginResult.value = ApiResult.Faliour(e)
                    isLoading.value = false
                }

                override fun onComplete() {
                }
            })
    }
}