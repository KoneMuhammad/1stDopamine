package com.example.taskamazing.datalayer.repository.offlinerepository

import com.example.taskamazing.datalayer.dao.DaoUser
import com.example.taskamazing.datalayer.mapper.toEntity
import com.example.taskamazing.datalayer.repository.RepositoryUser
import com.example.taskamazing.domainmodel.ModelUser
import javax.inject.Inject


class OfflineUser@Inject constructor(private val daoUser: DaoUser) : RepositoryUser {
    override suspend fun upsertNewUser(user: ModelUser) =
        daoUser.upsertNewUser(user.toEntity())

    override suspend fun deleteUser(userId: Long) =
        daoUser.deleteUser(userId)
}
