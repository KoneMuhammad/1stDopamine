package com.example.taskamazing.datalayer.repository.offlinerepository

import com.example.taskamazing.datalayer.dao.DaoTaskWeather
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.mapper.toDomain
import com.example.taskamazing.datalayer.mapper.toEntity
import com.example.taskamazing.datalayer.repository.RepositoryTaskWeather
import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.enumclass.weather_type
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineTaskWeather@Inject constructor(private val daoTaskWeather: DaoTaskWeather):
    RepositoryTaskWeather {
    override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather) =
        daoTaskWeather.upsertTaskImage(taskWeather.toEntity())

    override fun getTaskWeather(weatherType: weather_type): Flow<ModelDTOTaskWeatherBackground>
        = daoTaskWeather.getTaskWeather(weatherType  ).map { it.toDomain() }


    override fun getMultipleTaskWeather(weatherType: Set<weather_type>): Flow<List<ModelDTOTaskWeatherBackground>> =
        daoTaskWeather.getMultipleTaskWeather(weatherType ).map { it.map { it.toDomain() } }

}
