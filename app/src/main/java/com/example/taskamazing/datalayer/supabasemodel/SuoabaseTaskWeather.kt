package com.example.taskamazing.datalayer.supabasemodel

import com.example.taskamazing.datalayer.enumclass.TimeOfDay
import com.example.taskamazing.datalayer.enumclass.TypeOfTask
import com.example.taskamazing.datalayer.enumclass.weather_type
import java.time.Instant

data class SuoabaseTaskImage(
    val taskImageId: Long,
    val createdAt: Instant,
    val weather_type: weather_type,
    val video_url: String,
)

