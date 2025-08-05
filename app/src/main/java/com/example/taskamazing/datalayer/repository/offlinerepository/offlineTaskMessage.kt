package com.example.taskamazing.datalayer.repository.offlinerepository

import com.example.taskamazing.datalayer.dao.DaoTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.mapper.toDomain
import com.example.taskamazing.datalayer.mapper.toEntity
import com.example.taskamazing.datalayer.repository.RepositoryTaskMessage
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class OfflineTask@Inject constructor(private val daoTaskMessage: DaoTaskMessage): RepositoryTaskMessage
{
    override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage)
    = daoTaskMessage.upsertTaskMessage(taskMessage.toEntity())

    override fun getTaskMessage(id: Long): Flow<ModelDTOTaskMessage>
    = daoTaskMessage.getTaskMessage(id).map { it.toDomain() }

    override fun getMultipleTaskMessage(ids: Set<Long>): Flow<List<ModelDTOTaskMessage>>
    = daoTaskMessage.getMultipleTaskMessage(ids).map { it.map { it.toDomain() } }
}