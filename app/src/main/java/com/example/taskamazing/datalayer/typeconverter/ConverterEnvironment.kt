package com.example.taskamazing.datalayer.typeconverter

import androidx.room.TypeConverter
import com.example.taskamazing.datalayer.enumclass.Environment

class ConverterEnvironment {

    @TypeConverter
    fun toEnvironment(value: String): Environment {
        return Environment.valueOf(value)
    }
    @TypeConverter
    fun fromEnvironment(value: Environment): String {
        return value.name
    }
}
