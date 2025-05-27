package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.entity.TaskWeather
import com.example.taskamazing.domainmodel.ModelTaskWeather

fun TaskWeather.toDomain(): ModelTaskWeather {
    return ModelTaskWeather(
        id = this.id,
        createdAt = this.createdAt,
        weather_type = this.weather_type,
        video_url = this.video_url)
}
fun ModelTaskWeather.toEntity(): TaskWeather{
return TaskWeather(
    id = this.id,
    createdAt = this.createdAt,
    weather_type = this.weather_type,
    video_url = this.video_url

)
}

