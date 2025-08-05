package com.example.taskamazing.errorhandler

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import okio.IOException
import retrofit2.HttpException

fun errorHandleMessage(throwable: Throwable): List<ErrorHandleObject> {
    return listOf(
        ErrorHandleObject(
            id = System.currentTimeMillis(),
            message = when(throwable){
                is IOException -> "NetworkRequest failed. be grateful for the phone you have"
                is HttpException -> "Server error (${throwable.code()})"
                is ClientRequestException-> "Request error (${throwable.response.status.value}"
                is ServerResponseException -> "Server error (${throwable.response.status.value}"
                else -> "Try again later and tell your parents you love them"
            }
        ))
}

