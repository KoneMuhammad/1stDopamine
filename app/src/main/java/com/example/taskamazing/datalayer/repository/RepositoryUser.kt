package com.example.taskamazing.datalayer.repository

import com.example.taskamazing.datalayer.entity.User
import com.example.taskamazing.datalayer.domainmodel.ModelUser

interface RepositoryUser {

    suspend fun addNewUser(email: String, password: String)

    suspend fun upsertNewUser(user: ModelUser)

    suspend fun deleteUser(id: Long)
}