package com.example.taskamazing.errorhandler

import okio.IOException
import retrofit2.HttpException

fun errorMessageHandler(throwable: Throwable): List<ErrorMessageObject> {
    return listOf(
        ErrorMessageObject(
            id = System.currentTimeMillis(),
            message = when(throwable){
                is IOException -> "NetworkRequest failed. be grateful for the phone you have"
                is HttpException -> "Server error (${throwable.code()})"
                else -> "Try again later and call your parents"
            }
        ))
}
