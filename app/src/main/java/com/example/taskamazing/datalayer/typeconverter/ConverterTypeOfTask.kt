package com.example.taskamazing.datalayer.typeconverter

import androidx.room.TypeConverter
import com.example.taskamazing.datalayer.enumclass.TimeOfDay
import com.example.taskamazing.datalayer.enumclass.type_of_task

class ConverterTypeOfTask {

    @TypeConverter
    fun toTypeOfTask (value: String): type_of_task {
        return type_of_task .valueOf(value)
    }
    @TypeConverter
    fun fromTypeOfTask (value: type_of_task ): String {
        return value.name
    }
}
