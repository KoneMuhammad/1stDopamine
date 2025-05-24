package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.entity.Task
import com.example.taskamazing.domainmodel.ModelTask

fun Task.toDomain(): ModelTask{
    return ModelTask(
        taskId = this.taskId,
        createdAt = this.createdAt,
        task = this.task
    )
}

fun ModelTask.toEntity(): Task{
    return Task(
        taskId = this.taskId,
        createdAt = this.createdAt,
        task = this.task
    )
}