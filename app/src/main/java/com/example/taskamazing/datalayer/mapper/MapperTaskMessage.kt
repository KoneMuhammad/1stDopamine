package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.entity.TaskMessage
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage

fun TaskMessage.toDomain(): ModelTaskMessage {
    return ModelTaskMessage(
        id = this.id,
        created_at = this.created_at,
        type_of_task = this.type_of_task,
        task_message = this.task_message,
        emblem_url = this.emblem_url
    )
}

fun ModelTaskMessage.toEntity(): TaskMessage{
    return TaskMessage(
        id = this.id,
        created_at = this.created_at,
        type_of_task = this.type_of_task,
        task_message = this.task_message,
        emblem_url = this.emblem_url
    )
}