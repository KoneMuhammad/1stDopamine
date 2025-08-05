package com.example.taskamazing.datalayer.mapper

import com.example.taskamazing.datalayer.dto.DTOTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage


fun DTOTaskMessage.toDomain(): ModelDTOTaskMessage{
    return ModelDTOTaskMessage(
        id = this.id,
        type_of_task = this.type_of_task,
        task_message = this.task_message,
        emblem_url = this.emblem_url
    )
}
fun ModelDTOTaskMessage.toEntity(): DTOTaskMessage{
    return DTOTaskMessage(
        id = this.id,
        type_of_task = this.type_of_task,
        task_message = this.task_message,
        emblem_url = this.emblem_url
    )
}