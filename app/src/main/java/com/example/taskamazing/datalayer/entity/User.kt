package com.example.taskamazing.datalayer.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity
data class User(
    @PrimaryKey val userId: String,
    val createdAt: Instant,
    val email: String,
    val displayName: String
)
