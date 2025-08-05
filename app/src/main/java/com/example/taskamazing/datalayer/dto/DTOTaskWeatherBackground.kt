package com.example.taskamazing.datalayer.dto

import androidx.room.ColumnInfo
import com.example.taskamazing.datalayer.enumclass.weather_type

data class DTOTaskWeatherBackground(
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "weather_type") val weather_type: weather_type,
    @ColumnInfo(name = "video_url") val video_url: String

)