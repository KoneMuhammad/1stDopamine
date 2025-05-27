package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.dto.DTOTaskWeatherBackground
import com.example.taskamazing.datalayer.entity.TaskWeather
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoTaskWeather {

    @Upsert
    fun upsertTaskImage(taskWeather: TaskWeather)

    @Query("SELECT * FROM TaskWeather WHERE id = :id")
    fun getTaskImage(id:Long): Flow<TaskWeather>

    @Query("SELECT * FROM TaskWeather WHERE id IN (:ids)")
    fun getMultipleTaskImage(ids: Set<Long>): Flow<List<TaskWeather>>

    @Query("SELECT id,weather_type,video_url FROM TaskWeather WHERE id IN (:ids)")
    fun getTaskImagePreview(ids: Set<Long>): Flow<List<DTOTaskWeatherBackground>>



}
