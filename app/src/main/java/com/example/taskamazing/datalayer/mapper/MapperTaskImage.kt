package com.example.taskamazing.datalayer.mapper

import android.view.Display.Mode
import com.example.taskamazing.datalayer.entity.TaskImage
import com.example.taskamazing.domainmodel.ModelTaskImage

fun TaskImage.toDomain(): ModelTaskImage{
    return ModelTaskImage(
        taskImageId = this.taskImageId,
        createdAt = this.createdAt,
        environment = this.environment,
        timeOfDay = this.timeOfDay,
        background = this.background,
        emblem = this.emblem
    )
}
fun ModelTaskImage.toEntity(): TaskImage{
return TaskImage(
    taskImageId = this.taskImageId,
    createdAt = this.createdAt,
    environment = this.environment,
    timeOfDay = this.timeOfDay,
    background = this.background,
    emblem = this.emblem
)
}

