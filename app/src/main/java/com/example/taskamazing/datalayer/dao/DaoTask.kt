package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoTask {

    @Upsert
    fun upsertTasks(task: Task)

    @Query("SELECT * FROM TASK WHERE taskId = :taskId")
    fun getTask(taskId:Long): Flow<Task>

    @Query("SELECT * FROM TASK WHERE taskId = :taskIds")
    fun getMultipleTasks(taskIds: Set<Long>): Flow<List<Task>>
}