package com.example.taskamazing.datalayer.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskamazing.datalayer.enumclass.TypeOfTask
import java.time.Instant


@Entity
data class Task(
    @PrimaryKey val id: Long,
    val createdAt: Instant,
    val typeOfTask: TypeOfTask,
    val taskMessage: String
)
