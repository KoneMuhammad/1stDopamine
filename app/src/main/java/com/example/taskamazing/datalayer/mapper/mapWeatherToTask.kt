package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.enumclass.weather_type

fun mapWeatherTypeToWeatherBackground(description: String?, icon: String?): weather_type {
    if (description == null || icon == null )return weather_type.ClOUDY //if anyone one of these equals null return this
    //if both of these equals null return this 
    return when {// + 01
        description.contains("Clouds", true) && icon.contains("01d")-> weather_type.ClOUDY
        description.contains("Rain", true)  && icon.contains("01d") -> weather_type.RAINING
        description.contains("Clear", true)&& icon.contains("01d")  ->  weather_type.SUNNY
        description.contains("Snow", true) && icon.contains("01d") -> weather_type.SNOWING
        description.contains("Fog", true) && icon.contains("01d")  ->  weather_type.FOG
        description.contains("Mist", true) && icon.contains("01d")  ->  weather_type.FOG
        description.contains("Drizzle", true) && icon.contains("01d") ->  weather_type.DRIZZLE

        description.contains("Rain", true)  && icon.contains("01n") -> weather_type.NIGHTRAIN
        description.contains("Clear", true)&& icon.contains("01n")  ->  weather_type.ClEARNIGHT
        description.contains("Snow", true) && icon.contains("01n") -> weather_type.NIGHTSNOW
        description.contains("Drizzle", true) && icon.contains("01n") ->  weather_type.NIGHTRAIN
        else -> weather_type.ClOUDY
    }
}


