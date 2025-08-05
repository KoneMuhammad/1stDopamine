package com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase

import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WrapperImplMessageSupabase(
   private val  client: SupabaseClient
): WrapperMessageSupabase {
    override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage) {
    }

    override suspend fun getTaskMessage(id: Long): ModelDTOTaskMessage  {
        return client
            .from("TaskMessage")
            .select(columns = Columns.list("type_of_task, task_message, emblem_url")){
                filter{ ModelTaskMessage::id eq id}
            }
            .decodeSingle<ModelDTOTaskMessage>()

    }

    override suspend fun getMultipleTaskMessage(ids: Set<Long>): List<ModelDTOTaskMessage> {
        if (ids.isEmpty()) return emptyList()

        return client
            .from("TaskMessage")
            .select(columns = Columns.list("type_of_task, task_message, emblem_url")){
                filter { ModelTaskMessage::id isIn ids.toList() }
            }

            .decodeList<ModelDTOTaskMessage>()

    }

}
