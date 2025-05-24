package com.example.taskamazing.datalayer.typeconverter

import androidx.room.TypeConverter
import com.example.taskamazing.datalayer.enumclass.TimeOfDay

class ConverterTimeOfDay {

    @TypeConverter
    fun toTimeOFDay(value: String): TimeOfDay {
        return TimeOfDay.valueOf(value)
    }
    @TypeConverter
    fun fromTimeOfDay(value: TimeOfDay): String {
        return value.name
    }
}

