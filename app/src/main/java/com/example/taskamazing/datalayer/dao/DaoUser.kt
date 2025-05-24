package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.entity.User

@Dao
interface DaoUser {

    @Upsert
    suspend fun upsertNewUser(user: User)

    @Query("DELETE FROM User WHERE userId = :userId")
    suspend fun deleteUser(userId: Long)

}