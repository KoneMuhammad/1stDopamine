package com.example.taskamazing.domainmodel

import androidx.room.PrimaryKey
import com.example.taskamazing.datalayer.enumclass.TypeOfTask
import java.time.Instant

data class ModelTask(
     val id: Long,
    val createdAt: Instant,
    val typeOfTask: TypeOfTask,
    val taskMessage: String
)
