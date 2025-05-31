package com.example.taskamazing.datalayer.repository.onlinerepository

import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.entity.TaskMessage
import com.example.taskamazing.datalayer.repository.RepositoryTaskMessage
import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SupabaseTaskMessageRepository@Inject constructor(private val client: SupabaseClient): RepositoryTaskMessage {
    override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage) {
    }

    override fun getTaskMessage(id: Long): Flow<ModelDTOTaskMessage> = flow {
        val response = client
            .from("TaskMessage")
            .select(columns = Columns.list("type_of_task, task_message, emblem_url")){
                filter{ ModelTaskMessage::id eq id}
            }
            .decodeSingle<ModelDTOTaskMessage>()
        emit(response)
    }

    override fun getMultipleTaskMessage(ids: Set<Long>): Flow<List<ModelDTOTaskMessage>> = flow {
        if (ids.isEmpty()) {
            emit(emptyList())
            return@flow
        }
        val response = client
            .from("TaskMessage")
            .select(columns = Columns.list("type_of_task, task_message, emblem_url")){
                        filter { ModelTaskMessage::id isIn ids.toList() }
            }

            .decodeList<ModelDTOTaskMessage>()
        emit(response)
    }

}
