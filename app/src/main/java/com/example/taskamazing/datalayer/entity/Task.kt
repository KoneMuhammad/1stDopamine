package com.example.taskamazing.datalayer.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant


@Entity
data class Task(
    @PrimaryKey val taskId: Long,
    val createdAt: Instant,
    val task: String
)
