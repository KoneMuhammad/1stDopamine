package com.example.taskamazing.datalayer.repository

import com.example.taskamazing.datalayer.dto.DTOTaskWeatherBackground
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.enumclass.weather_type
import kotlinx.coroutines.flow.Flow

interface RepositoryTaskWeather {

    suspend fun upsertTaskImage(taskWeather: ModelTaskWeather)
    fun getTaskWeather(weatherType: weather_type): Flow<ModelDTOTaskWeatherBackground>
    fun getMultipleTaskWeather(weatherType: Set<weather_type>): Flow<List<ModelDTOTaskWeatherBackground>>

}