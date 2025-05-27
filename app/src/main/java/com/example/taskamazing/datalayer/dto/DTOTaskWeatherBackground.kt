package com.example.taskamazing.datalayer.dto

import androidx.room.ColumnInfo

data class DTOTaskImageBackground(
    @ColumnInfo(name = "taskImageId") val taskImageId: Long,
    @ColumnInfo(name = "background") val background: String
)