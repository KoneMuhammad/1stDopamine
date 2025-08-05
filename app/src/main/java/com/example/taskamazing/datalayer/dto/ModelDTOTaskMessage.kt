package com.example.taskamazing.datalayer.dto

import com.example.taskamazing.datalayer.enumclass.type_of_task

data class ModelDTOTaskMessage(
    val id: Long,
    val type_of_task: type_of_task,
    val task_message: String,
    val emblem_url: String
)
