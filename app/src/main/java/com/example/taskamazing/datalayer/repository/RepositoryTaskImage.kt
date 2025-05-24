package com.example.taskamazing.datalayer.repository

import com.example.taskamazing.datalayer.dto.DTOTaskImageBackground
import com.example.taskamazing.datalayer.dto.ModelDTOTaskImageBackground
import com.example.taskamazing.datalayer.entity.TaskImage
import com.example.taskamazing.domainmodel.ModelTaskImage
import kotlinx.coroutines.flow.Flow

interface RepositoryTaskImage {

    suspend fun upsertTaskImage(taskImage: ModelTaskImage)
    fun getTaskImage(taskImageId:Long): Flow<ModelTaskImage>
    fun getMultipleTaskImage(taskImageIds: Set<Long>): Flow<List<ModelTaskImage>>
    fun getTaskImagePreview(taskImageIds: Set<Long>): Flow<List<ModelDTOTaskImageBackground>>

}