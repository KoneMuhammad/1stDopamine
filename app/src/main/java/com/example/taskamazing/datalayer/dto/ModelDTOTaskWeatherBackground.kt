package com.example.taskamazing.datalayer.dto

import androidx.room.ColumnInfo

data class ModelDTOTaskImageBackground(
   @ColumnInfo(name = "id") val id: Long,
   @ColumnInfo(name = "video_url") val video_url: String,
   @ColumnInfo(name = "weather_type") val weather_type:String
)
