package com.example.taskamazing.datalayer.typeconverter

import androidx.room.TypeConverter
import com.example.taskamazing.datalayer.enumclass.weather_type

class ConverterEnvironment {

    @TypeConverter
    fun toEnvironment(value: String): weather_type {
        return weather_type.valueOf(value)
    }
    @TypeConverter
    fun fromEnvironment(value: weather_type): String {
        return value.name
    }
}
