package com.example.taskamazing.datalayer.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskamazing.datalayer.enumclass.type_of_task
import java.time.Instant


@Entity
data class TaskMessage(
    @PrimaryKey val id: Long,
    val created_at: Instant,
    val type_of_task: type_of_task,
    val task_message: String,
    val emblem_url: String
)
