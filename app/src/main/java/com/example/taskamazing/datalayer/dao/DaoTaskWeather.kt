package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.dto.DTOTaskWeatherBackground
import com.example.taskamazing.datalayer.entity.TaskWeather
import com.example.taskamazing.datalayer.enumclass.weather_type
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoTaskWeather {

    @Upsert
    suspend fun upsertTaskImage(taskWeather: TaskWeather)

    @Query("SELECT id,weather_type,video_url FROM TaskWeather WHERE weather_type = :weatherType")
    fun getTaskWeather(weatherType:weather_type): Flow<DTOTaskWeatherBackground>

    @Query("SELECT id,weather_type,video_url FROM TaskWeather WHERE weather_type IN (:weatherType)")
    fun getMultipleTaskWeather(weatherType: Set<weather_type>): Flow<List<DTOTaskWeatherBackground>>


}

