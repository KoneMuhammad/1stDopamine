package com.example.taskamazing.datalayer.mapper


import com.example.taskamazing.datalayer.domainmodel.Current
import com.example.taskamazing.datalayer.domainmodel.WeatherApiResponse
import com.example.taskamazing.datalayer.dto.SimplifiedWeather

fun WeatherApiResponse.toSimplified(): SimplifiedWeather {
    return SimplifiedWeather(
        description = current.weather.firstOrNull()?.main ?: "Unknown",
        //whats the first piece of data that comes out if like some sort of rust before water
        //then do getornull(1)
        icon =  current.weather.firstOrNull()?.icon?: "Unknown"
    )
}
//elvis operator 0
