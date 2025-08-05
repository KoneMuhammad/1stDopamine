package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.entity.TaskWeather
import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather

fun TaskWeather.toDomain(): ModelTaskWeather {
    return ModelTaskWeather(
        id = this.id,
        created_at = this.created_at,
        weather_type = this.weather_type,
        video_url = this.video_url)
}
fun ModelTaskWeather.toEntity(): TaskWeather{
return TaskWeather(
    id = this.id,
    created_at = this.created_at,
    weather_type = this.weather_type,
    video_url = this.video_url

)
}

