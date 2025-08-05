package com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase

import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.enumclass.weather_type
import kotlinx.coroutines.flow.Flow

interface WrapperWeatherSupabase{

    suspend fun upsertTaskImage(taskWeather: ModelTaskWeather)
    suspend fun getTaskWeather(weatherType: weather_type): ModelDTOTaskWeatherBackground
    suspend fun getMultipleTaskWeather(weatherType: Set<weather_type>): List<ModelDTOTaskWeatherBackground>
    
}