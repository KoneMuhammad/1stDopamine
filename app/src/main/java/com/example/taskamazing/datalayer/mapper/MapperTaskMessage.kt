package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.entity.Task
import com.example.taskamazing.domainmodel.ModelTask

fun Task.toDomain(): ModelTask{
    return ModelTask(
        id = this.id,
        createdAt = this.createdAt,
        typeOfTask = this.typeOfTask,
        taskMessage = this.taskMessage
    )
}

fun ModelTask.toEntity(): Task{
    return Task(
        id = this.id,
        createdAt = this.createdAt,
        typeOfTask = this.typeOfTask,
        taskMessage = this.taskMessage
    )
}