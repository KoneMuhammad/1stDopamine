package com.example.taskamazing.datalayer.supabasemodel

import java.time.Instant

data class SupabaseUser(
val userId: String,
val createdAt: Instant,
val email: String,
val displayName: String
)
