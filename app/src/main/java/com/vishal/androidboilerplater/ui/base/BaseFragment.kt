package com.vishal.androidboilerplater.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {
    lateinit var mActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        if (context is BaseActivity) {
            mActivity = context
        }
        super.onAttach(context)
    }

    fun setActvityTitle(title: String) {
        if (::mActivity.isInitialized) mActivity.setActivityTitle(title)
    }

    fun isNetworkConnected(): Boolean {
        return if (::mActivity.isInitialized) mActivity.isNetworkConnected() else false
    }

    fun hideKeyboard() {
        if (::mActivity.isInitialized) mActivity.hideKeyboard()
    }

    fun showToast(message: String) {
        if (::mActivity.isInitialized) mActivity.showToast(message)
    }

    fun showSnackbar(message: String) {
        if (::mActivity.isInitialized) mActivity.showSnackBar(message)
    }

}
