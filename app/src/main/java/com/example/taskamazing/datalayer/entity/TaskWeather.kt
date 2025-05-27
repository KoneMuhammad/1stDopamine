package com.example.taskamazing.datalayer.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.taskamazing.datalayer.enumclass.weather_type
import com.example.taskamazing.datalayer.enumclass.TimeOfDay
import com.example.taskamazing.datalayer.enumclass.TypeOfTask
import java.time.Instant

@Entity
data class TaskImage(
    @PrimaryKey val taskImageId: Long,
    val createdAt: Instant,
    val weather_type:weather_type,
    val video_url: String,
)
