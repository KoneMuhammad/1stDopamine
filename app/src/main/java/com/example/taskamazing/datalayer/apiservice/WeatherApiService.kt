package com.example.taskamazing.datalayer.apiservice

import com.example.taskamazing.datalayer.domainmodel.WeatherApiResponse
import com.google.android.datatransport.runtime.dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApiService {
    @GET("data/3.0/onecall?")
    suspend fun getWeather(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("appid") apiKey: String,
    ):
            Response<WeatherApiResponse>
}
