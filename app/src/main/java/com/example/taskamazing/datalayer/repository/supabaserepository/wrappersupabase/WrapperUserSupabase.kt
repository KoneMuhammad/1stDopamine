package com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase

import com.example.taskamazing.datalayer.domainmodel.ModelUser
import io.github.jan.supabase.SupabaseClient

interface WrapperUserSupabase {

    suspend fun addNewUser(email: String, password: String)

    suspend fun upsertNewUser(user: ModelUser)

    suspend fun deleteUser(id: Long)
}