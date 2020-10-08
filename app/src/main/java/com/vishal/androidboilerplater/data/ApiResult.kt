package com.vishal.androidboilerplater.data

sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class Faliour(val exception: Throwable) : ApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Faliour -> "Error[exception=$exception]"
        }
    }
}
