package com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase

import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import kotlinx.coroutines.flow.Flow

interface WrapperMessageSupabase {

    suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage)
    suspend fun getTaskMessage(id:Long): ModelDTOTaskMessage
    suspend fun getMultipleTaskMessage(ids: Set<Long>): List<ModelDTOTaskMessage>

}

//