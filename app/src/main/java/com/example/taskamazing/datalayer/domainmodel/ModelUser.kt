package com.example.taskamazing.datalayer.domainmodel

import androidx.room.PrimaryKey
import java.time.Instant

data class ModelUser(
     val id: Long,
    val created_at: Instant,
    val email: String,
    val display_name: String
)
