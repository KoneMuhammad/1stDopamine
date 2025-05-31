package com.example.taskamazing.domainmodel

import androidx.room.PrimaryKey
import java.time.Instant

data class ModelUser(
     val id: String,
    val created_at: Instant,
    val email: String,
    val display_name: String
)
//repositories
//viewmodel
