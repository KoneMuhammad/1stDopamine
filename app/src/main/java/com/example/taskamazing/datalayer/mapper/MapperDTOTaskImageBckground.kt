package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.dto.DTOTaskImageBackground
import com.example.taskamazing.datalayer.dto.ModelDTOTaskImageBackground

fun DTOTaskImageBackground.toDomain(): ModelDTOTaskImageBackground {
    return  ModelDTOTaskImageBackground(
        taskImageId = this.taskImageId,
        background = this.background
    )
}

fun ModelDTOTaskImageBackground.toEntity(): DTOTaskImageBackground{
    return DTOTaskImageBackground(
        taskImageId = this.taskImageId,
        background = this.background
    )
}