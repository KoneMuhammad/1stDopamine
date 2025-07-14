package com.example.taskamazing.uilayer.viewmodel
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*

val client = HttpClient(CIO) {
    install(HttpTimeout) {
        requestTimeoutMillis = 3000
    }
}
