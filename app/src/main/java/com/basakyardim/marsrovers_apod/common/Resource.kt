package com.basakyardim.marsrovers_apod.common

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<Any>(data: Any) : Resource<Any>(data)
    class Error<Any>(message: String, data: Any? = null) : Resource<Any>(data, message)
    class Loading<Any>(data: Any? = null) : Resource<Any>(data)

}
