package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.enumclass.weather_type


fun weatherTypeToDto(type: weather_type):ModelDTOTaskWeatherBackground{
    return ModelDTOTaskWeatherBackground(
        weather_type = type,
        video_url = "Cloudy Weather MP4",
        id = 2
    )
}