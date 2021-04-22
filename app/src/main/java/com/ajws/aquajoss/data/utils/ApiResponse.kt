package com.ajws.aquajoss.data.utils

data class ApiResponse<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): ApiResponse<T> = ApiResponse(Status.SUCCESS, data, null)
        fun <T> error(msg: String, data: T?) = ApiResponse(Status.ERROR, data, msg)
        fun <T> loading(data: T?) = ApiResponse(Status.LOADING, data, null)
    }
}