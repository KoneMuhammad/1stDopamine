package com.example.taskamazing.datalayer.repository

import android.view.Display.Mode
import com.example.taskamazing.datalayer.entity.Task
import com.example.taskamazing.domainmodel.ModelTask
import kotlinx.coroutines.flow.Flow

interface RepositoryTask {

    suspend fun upsertTasks(task: ModelTask)
    fun getTask(taskId:Long): Flow<ModelTask>
    fun getMultipleTasks(taskIds: Set<Long>): Flow<List<ModelTask>>

}
//repo 2 offline and supabase
//so repository is just for doing operations weather or not thats offline
//or through a cloud
//offline repository then online one
