package com.example.taskamazing.datalayer.repository.weatherapirepository

import android.location.Location
import com.example.taskamazing.datalayer.apiservice.WeatherApiService
import com.example.taskamazing.datalayer.dto.SimplifiedWeather
import com.example.taskamazing.datalayer.mapper.toSimplified
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository@Inject constructor(private val api: WeatherApiService) {

     fun fetchWeather(latitude: String,longitude: String, apiKey: String): Flow<SimplifiedWeather?> = flow {
        val response = api.getWeather(latitude,longitude, apiKey)
            val dto = response.body()?.toSimplified()
            emit(dto)
        }
    }
//check the  http network thing  the get q and stuff (could also learn that )
//also check the rest of the function

