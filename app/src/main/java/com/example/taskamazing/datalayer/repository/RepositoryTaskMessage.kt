package com.example.taskamazing.datalayer.repository

import com.example.taskamazing.domainmodel.ModelTaskMessage
import kotlinx.coroutines.flow.Flow

interface RepositoryTask {

    suspend fun upsertTasks(task: ModelTaskMessage)
    fun getTask(taskId:Long): Flow<ModelTaskMessage>
    fun getMultipleTasks(taskIds: Set<Long>): Flow<List<ModelTaskMessage>>

}
//repo 2 offline and supabase
//so repository is just for doing operations weather or not thats offline
//or through a cloud
//offline repository then online one
