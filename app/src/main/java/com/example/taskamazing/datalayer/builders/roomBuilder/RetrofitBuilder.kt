package com.example.taskamazing.datalayer.builders.roomBuilder.retrofitbuilder

import com.example.taskamazing.datalayer.apiservice.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("http://api.weatherapi.com/v1")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val api = retrofit.create(WeatherApiService::class.java)


