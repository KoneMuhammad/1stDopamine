package com.example.taskamazing.datalayer.repository

import com.example.taskamazing.datalayer.entity.User
import com.example.taskamazing.domainmodel.ModelUser

interface RepositoryUser {

    suspend fun upsertNewUser(user: ModelUser)

    suspend fun deleteUser(userId: Long)
}