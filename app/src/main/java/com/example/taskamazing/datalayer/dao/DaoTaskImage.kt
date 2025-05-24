package com.example.taskamazing.datalayer.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.taskamazing.datalayer.dto.DTOTaskImageBackground
import com.example.taskamazing.datalayer.entity.TaskImage
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoTaskImage {

    @Upsert
    fun upsertTaskImage(taskImage: TaskImage)

    @Query("SELECT * FROM TaskImage WHERE taskImageId = :taskImageId")
    fun getTaskImage(taskImageId:Long): Flow<TaskImage>

    @Query("SELECT * FROM TaskImage WHERE taskImageId IN (:taskImageIds)")
    fun getMultipleTaskImage(taskImageIds: Set<Long>): Flow<List<TaskImage>>

    @Query("SELECT taskImageId,background FROM TaskImage WHERE taskImageId IN (:taskImageIds)")
    fun getTaskImagePreview(taskImageIds: Set<Long>): Flow<List<DTOTaskImageBackground>>



}
