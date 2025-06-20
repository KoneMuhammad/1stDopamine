package com.example.taskamazing.domainmodel

import com.example.taskamazing.datalayer.enumclass.type_of_task
import java.time.Instant

data class ModelTaskMessage(
    val id: Long,
    val created_at: Instant,
    val type_of_task: type_of_task,
    val task_message: String,
    val emblem_url: String
)
