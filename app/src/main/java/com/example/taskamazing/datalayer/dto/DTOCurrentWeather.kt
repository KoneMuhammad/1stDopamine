package com.example.taskamazing.datalayer.apiservice

data class DTOCurrentWeather(
    val tempCelsius: Double,
    val conditionText: String,
    val humidity: Int
)
