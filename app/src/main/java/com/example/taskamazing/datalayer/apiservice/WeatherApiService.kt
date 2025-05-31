package com.example.taskamazing.datalayer.apiservice

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("/current.json")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("key") apiKey: String
    ): Response<CurrentWeather>
}

