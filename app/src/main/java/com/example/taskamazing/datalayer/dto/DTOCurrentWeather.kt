package com.example.taskamazing.datalayer.dto

import com.example.taskamazing.datalayer.apiservice.WeatherApiService
import com.example.taskamazing.datalayer.mapper.mapWeatherTypeToWeatherBackground
import com.example.taskamazing.locationbuilder.getCurrentLocation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
data class SimplifiedWeather(
    val description: String,
    val icon: String
)
