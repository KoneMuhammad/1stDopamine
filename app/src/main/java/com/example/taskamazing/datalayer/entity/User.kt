package com.example.taskamazing.datalayer.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
data class User(
    @PrimaryKey val id: Long,
    val created_at: Instant,
    val email: String,
    val display_name: String
)
