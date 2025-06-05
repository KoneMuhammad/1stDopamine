package com.example.taskamazing.datalayer.supabasemodel

class WrapperImplWeatherSupabase(
    private val client: SupabaseClient
): SupabaseReturner {

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
