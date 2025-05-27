package com.example.taskamazing.datalayer.repository.offlinerepository

import com.example.taskamazing.datalayer.dao.DaoTaskMessage
import com.example.taskamazing.datalayer.mapper.toDomain
import com.example.taskamazing.datalayer.mapper.toEntity
import com.example.taskamazing.datalayer.repository.RepositoryTask
import com.example.taskamazing.domainmodel.ModelTaskMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class OfflineTask@Inject constructor(private val daoTask: DaoTaskMessage): RepositoryTask
{
    override suspend fun upsertTasks(task: ModelTaskMessage) =
daoTask.upsertTasks(task.toEntity())


    override fun getTask(taskId: Long): Flow<ModelTaskMessage> =
        daoTask.getTask(taskId).map { it-> it.toDomain() }

    override fun getMultipleTasks(taskIds: Set<Long>): Flow<List<ModelTaskMessage>> =
        daoTask.getMultipleTasks(taskIds) .map { it ->
            it.map { it.toDomain() }
        }
}