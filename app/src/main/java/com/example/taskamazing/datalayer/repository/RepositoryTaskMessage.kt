package com.example.taskamazing.datalayer.repository

import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import kotlinx.coroutines.flow.Flow

interface RepositoryTaskMessage {

    suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage)
    fun getTaskMessage(id:Long): Flow<ModelDTOTaskMessage>
    fun getMultipleTaskMessage(ids: Set<Long>): Flow<List<ModelDTOTaskMessage>>


}
