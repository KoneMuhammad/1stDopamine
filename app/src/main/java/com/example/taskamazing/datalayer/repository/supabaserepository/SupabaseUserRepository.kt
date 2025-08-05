package com.example.taskamazing.datalayer.repository.supabaserepository

import com.example.taskamazing.datalayer.repository.RepositoryUser
import com.example.taskamazing.datalayer.domainmodel.ModelUser
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperUserSupabase
import javax.inject.Inject

class SupabaseUserRepository@Inject constructor(private val wrapper:WrapperUserSupabase ): RepositoryUser {
    override suspend fun addNewUser(email: String, password: String) {
        val addUser = wrapper.addNewUser(email,password)
    }

    override suspend fun upsertNewUser(user: ModelUser) {
       val upsertNewUser = wrapper.upsertNewUser(user)
    }

    override suspend fun deleteUser(id: Long) {
       val removeUserColumn = wrapper.deleteUser(id)
    }

}
