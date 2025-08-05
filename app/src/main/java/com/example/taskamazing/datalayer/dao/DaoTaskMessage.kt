package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.dto.DTOTaskMessage
import com.example.taskamazing.datalayer.entity.TaskMessage
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoTaskMessage {

    @Upsert
   suspend fun upsertTaskMessage(taskMessage: TaskMessage)

    @Query("SELECT id, type_of_task, task_message,emblem_url FROM TaskMessage where id = :id")
    fun getTaskMessage(id:Long): Flow<DTOTaskMessage>

    @Query("SELECT id, type_of_task, task_message,emblem_url FROM TaskMessage where id IN (:ids)")
    fun getMultipleTaskMessage(ids: Set<Long>): Flow<List<DTOTaskMessage>>


}



