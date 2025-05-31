package com.example.taskamazing.datalayer.roombuilder

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taskamazing.datalayer.dao.DaoTaskMessage
import com.example.taskamazing.datalayer.dao.DaoTaskWeather
import com.example.taskamazing.datalayer.dao.DaoUser
import com.example.taskamazing.datalayer.entity.TaskMessage
import com.example.taskamazing.datalayer.entity.TaskWeather
import com.example.taskamazing.datalayer.entity.User
import com.example.taskamazing.datalayer.typeconverter.ConverterWeatherType
import com.example.taskamazing.datalayer.typeconverter.ConverterTimeOfDay
import com.example.taskamazing.datalayer.typeconverter.ConverterTypeOfTask
import com.example.taskamazing.datalayer.typeconverter.TimeConverter

@Database
    (entities = [TaskWeather::class, TaskMessage::class, User::class], version = 1)

@TypeConverters(
    TimeConverter::class, ConverterTimeOfDay::class, ConverterTypeOfTask::class,
    ConverterWeatherType::class)
abstract class LocalDatabase: RoomDatabase() {

    abstract fun getUserDao(): DaoUser
    abstract fun getTaskWeatherDao(): DaoTaskWeather
    abstract fun getTaskMessageDao(): DaoTaskMessage
}