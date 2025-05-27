package com.example.taskamazing.datalayer.supabasemodel

import com.example.taskamazing.datalayer.enumclass.TypeOfTask
import java.time.Instant

data class SupabaseTask(
    val id: Long,
    val createdAt: Instant,
    val typeOfTask: TypeOfTask,
    val taskMessage: String
)
