package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.entity.TaskMessage
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoTask {

    @Upsert
    fun upsertTasks(task: TaskMessage)

    @Query("SELECT * FROM TaskMessage WHERE id = :id")
    fun getTask(id:Long): Flow<TaskMessage>

    @Query("SELECT * FROM TaskMessage WHERE id = :ids")
    fun getMultipleTasks(ids: Set<Long>): Flow<List<TaskMessage>>

    @Query("SELECT type_of_task, task_message,emblem_url FROM TaskMessage where id = :id")
}