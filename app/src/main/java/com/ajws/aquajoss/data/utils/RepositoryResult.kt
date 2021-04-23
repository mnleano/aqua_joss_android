package com.ajws.aquajoss.data.utils

data class RepositoryResult<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): RepositoryResult<T> = RepositoryResult(Status.SUCCESS, data, null)
        fun <T> error(msg: String, data: T?) = RepositoryResult(Status.ERROR, data, msg)
        fun <T> loading(data: T?) = RepositoryResult(Status.LOADING, data, null)
    }
}