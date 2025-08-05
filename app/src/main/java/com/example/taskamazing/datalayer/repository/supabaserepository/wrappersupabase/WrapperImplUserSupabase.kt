package com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase

import com.example.taskamazing.datalayer.domainmodel.ModelUser
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.from


class WrapperImplUserSupabase(private val client: SupabaseClient)
    :WrapperUserSupabase
// inherit from
//can use this classes functions and methods -+
///ovveride the functions and add its own implementations
{
    override suspend fun addNewUser(email: String, password: String) {
        val response =  client.auth.signUpWith(Email){
            this.email = email
            this.password = password
        }

    }

    override suspend fun upsertNewUser(user: ModelUser) {
        val response = client
            .from("User")
            .upsert(user)
    }

    override suspend fun deleteUser(id: Long) {
        val response = client
            .from("User")
            .delete{
                filter { ModelUser::id  eq id }
            }

    }
}
