package com.example.taskamazing.datalayer.repository.onlinerepository

import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.repository.RepositoryTaskWeather
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SupabaseTaskWeatherRepository@Inject constructor(private val client: SupabaseClient):RepositoryTaskWeather{
    override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather) {
//
    }

    override fun getTaskWeather(id: Long): Flow<ModelDTOTaskWeatherBackground> = flow {
       val response = client
           .from("TaskWeather")
           .select(columns = Columns.list("id, weather_type,video_url")){
               filter { ModelTaskWeather::id eq id }
           }
           .decodeSingle<ModelDTOTaskWeatherBackground>()
        emit(response)
    }

    override fun getMultipleTaskWeather(ids: Set<Long>): Flow<List<ModelDTOTaskWeatherBackground>> =flow {
        if (ids.isEmpty()) {
            emit(emptyList())
            return@flow
        }
        val response = client
            .from("TaskWeather")
            .select(columns = Columns.list("id, weather_type,video_url")){
                filter { ModelTaskWeather::id isIn ids.toList() }
            }

            .decodeList<ModelDTOTaskWeatherBackground>()
        emit(response)
    }
}