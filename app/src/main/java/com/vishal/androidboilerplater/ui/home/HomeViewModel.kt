package com.vishal.androidboilerplater.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.vishal.androidboilerplater.data.local.SessionManager
import com.vishal.androidboilerplater.data.remote.RequestInterface

class HomeViewModel @ViewModelInject constructor(
    val sessionManager: SessionManager,
    val requestInterface: RequestInterface
) : ViewModel() {


}