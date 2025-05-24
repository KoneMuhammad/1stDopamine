package com.example.taskamazing.datalayer.typeconverter

import androidx.room.TypeConverter
import java.time.Instant

class TimeConverter {

    @TypeConverter
    fun fromInstant(instant: Instant?): Long? {
        return instant?.toEpochMilli()
    }

    @TypeConverter
    fun toInstant(timestamp: Long?): Instant? {
        return timestamp?.let { Instant.ofEpochMilli(it) }
    }
}