package com.example.taskamazing.datalayer.dto

import com.example.taskamazing.datalayer.enumclass.weather_type

data class ModelDTOTaskWeatherBackground(
    val id: Long,
    val weather_type: weather_type,
    val video_url:String
)
