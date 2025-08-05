package com.example.taskamazing.datalayer.dto

import androidx.room.ColumnInfo
import com.example.taskamazing.datalayer.enumclass.type_of_task

data class DTOTaskMessage(
    @ColumnInfo(name = "id")val id: Long,
    @ColumnInfo(name = "type_of_task")val type_of_task: type_of_task,
    @ColumnInfo(name = "task_message")val task_message: String,
    @ColumnInfo(name = "emblem_url")val emblem_url: String
)

//learned dto
//you actually have the coolumninfo annotation
//and then name =n


