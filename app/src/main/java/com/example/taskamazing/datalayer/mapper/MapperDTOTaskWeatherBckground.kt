package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.dto.DTOTaskWeatherBackground
import com.example.taskamazing.datalayer.dto.ModelDTOTaskImageBackground

fun DTOTaskWeatherBackground.toDomain(): ModelDTOTaskImageBackground {
    return  ModelDTOTaskImageBackground(
        taskImageId = this.taskImageId,
        background = this.background
    )
}

fun ModelDTOTaskImageBackground.toEntity(): DTOTaskWeatherBackground{
    return DTOTaskWeatherBackground(
        taskImageId = this.taskImageId,
        background = this.background
    )
}