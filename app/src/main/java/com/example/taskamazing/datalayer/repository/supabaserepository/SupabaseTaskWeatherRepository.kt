package com.example.taskamazing.datalayer.repository.supabaserepository

import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.repository.RepositoryTaskWeather
import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.dto.DTOTaskMessage
import com.example.taskamazing.datalayer.enumclass.weather_type
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperWeatherSupabase
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.JsonNames
import javax.inject.Inject

class SupabaseTaskWeatherRepository@Inject constructor(private val wrapper:WrapperWeatherSupabase ):RepositoryTaskWeather {
    override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather) {
        TODO("Not yet implemented")
    }

    override fun getTaskWeather(weatherType: weather_type): Flow<ModelDTOTaskWeatherBackground> = flow {
        val taskWeather = wrapper.getTaskWeather(weatherType)
        emit(taskWeather)
    }

    override fun getMultipleTaskWeather(weatherType: Set<weather_type>):
            Flow<List<ModelDTOTaskWeatherBackground>> =  flow{
        val multipleWeather = wrapper.getMultipleTaskWeather(weatherType)
    }
}
suspend fun flowpractice()= flow<DTOTaskMessage>{
    println("yeah ")
    /**
     * code inside doesnt run immediately only when someone collects
     * its a cold flow 
     */
}
