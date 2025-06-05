package com.example.taskamazing.datalayer.supabasemodel

import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import kotlinx.coroutines.flow.Flow

interface SupabaseWeatherReturner{

    suspend fun upsertTaskImage(taskWeather: ModelTaskWeather)
    fun getTaskWeather(id:Long): Flow<ModelDTOTaskWeatherBackground>
    fun getMultipleTaskWeather(ids: Set<Long>): Flow<List<ModelDTOTaskWeatherBackground>>
    
}