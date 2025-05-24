package com.example.taskamazing.datalayer.typeconverter

import androidx.room.TypeConverter
import com.example.taskamazing.datalayer.enumclass.TimeOfDay
import com.example.taskamazing.datalayer.enumclass.TypeOfTask

class ConverterTypeOfTask {

    @TypeConverter
    fun toTypeOfTask (value: String): TypeOfTask {
        return TypeOfTask .valueOf(value)
    }
    @TypeConverter
    fun fromTypeOfTask (value: TypeOfTask ): String {
        return value.name
    }
}
