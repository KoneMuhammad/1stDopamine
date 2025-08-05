package com.example.taskamazing.datalayer.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskamazing.datalayer.enumclass.weather_type
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseInternal
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.FlowType
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.realtime.realtime
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import java.time.Instant
import javax.inject.Singleton

@Entity
data class TaskWeather(
    @PrimaryKey val id: Long,
    val created_at: Instant,
    val weather_type:weather_type,
    val video_url: String,
)
