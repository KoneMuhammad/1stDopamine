package com.example.taskamazing.domainmodel

import com.example.taskamazing.datalayer.enumclass.weather_type
import java.time.Instant

data class ModelTaskWeather(
    val id: Long,
    val created_at: Instant,
    val weather_type: weather_type,
    val video_url: String,
)
