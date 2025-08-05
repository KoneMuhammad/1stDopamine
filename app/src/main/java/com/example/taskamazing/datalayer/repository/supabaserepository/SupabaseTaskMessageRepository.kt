package com.example.taskamazing.datalayer.repository.supabaserepository

import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.repository.RepositoryTaskMessage
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperMessageSupabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SupabaseTaskMessageRepository@Inject constructor(private val wrapper: WrapperMessageSupabase): RepositoryTaskMessage {
    override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage) {
        TODO("Not yet implemented")
    }

    override fun getTaskMessage(id: Long): Flow<ModelDTOTaskMessage> = flow{

        val singleMessage = wrapper.getTaskMessage(id)
    }

    override fun getMultipleTaskMessage(ids: Set<Long>): Flow<List<ModelDTOTaskMessage>> = flow{

        val mutlipleMessages = wrapper.getMultipleTaskMessage(ids)
    }
}
