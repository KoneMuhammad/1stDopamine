package com.example.taskamazing.datalayer.supabasemodel

import java.time.Instant

data class SupabaseUser(
val id: String,
val created_at: Instant,
val email: String,
val displayName: String
)
