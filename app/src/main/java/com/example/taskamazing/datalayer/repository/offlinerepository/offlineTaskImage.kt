package com.example.taskamazing.datalayer.repository.offlinerepository

import com.example.taskamazing.datalayer.dao.DaoTaskImage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskImageBackground
import com.example.taskamazing.datalayer.mapper.toDomain
import com.example.taskamazing.datalayer.mapper.toEntity
import com.example.taskamazing.datalayer.repository.RepositoryTaskImage
import com.example.taskamazing.domainmodel.ModelTaskImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineTaskImage@Inject constructor(private val daoTaskImage: DaoTaskImage):
    RepositoryTaskImage {

    override suspend fun upsertTaskImage(taskImage: ModelTaskImage) {
        daoTaskImage.upsertTaskImage(taskImage.toEntity())
    }

    override fun getTaskImage(taskImageId: Long): Flow<ModelTaskImage> =
        daoTaskImage.getTaskImage(taskImageId) .map {
            it -> it.toDomain()  }

    override fun getMultipleTaskImage(taskImageIds: Set<Long>): Flow<List<ModelTaskImage>> =
        daoTaskImage.getMultipleTaskImage(taskImageIds) .map {
            it -> it.map { it.toDomain() } }

    override fun getTaskImagePreview(taskImageIds: Set<Long>): Flow<List<ModelDTOTaskImageBackground>> =
        daoTaskImage.getTaskImagePreview(taskImageIds) .map { it -> it.map { it.toDomain() } }
    }
