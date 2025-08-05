package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.dto.DTOTaskWeatherBackground
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground

fun DTOTaskWeatherBackground.toDomain(): ModelDTOTaskWeatherBackground {
    return  ModelDTOTaskWeatherBackground(
        id = this.id,
        weather_type = this.weather_type,
        video_url = this.video_url
    )
}

fun ModelDTOTaskWeatherBackground.toEntity(): DTOTaskWeatherBackground{
    return DTOTaskWeatherBackground(
        id = this.id,
        weather_type = this.weather_type,
        video_url = this.video_url
    )
}