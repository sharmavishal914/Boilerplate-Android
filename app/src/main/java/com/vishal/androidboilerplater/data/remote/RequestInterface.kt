package com.vishal.androidboilerplater.data.remote

import com.vishal.androidboilerplater.data.model.Model
import com.vishal.androidboilerplater.ui.authentication.login.model.LoginResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface RequestInterface {
    @GET("?service=ip")
    fun getServiceIP(): Observable<LoginResult>

    // https://mobilewash-1147.firebaseio.com/.json
    @GET
    fun getMW(@Url string: String): Observable<Model>

}