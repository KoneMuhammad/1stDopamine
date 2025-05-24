package com.example.taskamazing.datalayer.roombuilder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.taskamazing.datalayer.dao.DaoTask
import com.example.taskamazing.datalayer.dao.DaoTaskImage
import com.example.taskamazing.datalayer.dao.DaoUser
import com.example.taskamazing.datalayer.entity.Task
import com.example.taskamazing.datalayer.entity.TaskImage
import com.example.taskamazing.datalayer.entity.User
import com.example.taskamazing.datalayer.typeconverter.ConverterEnvironment
import com.example.taskamazing.datalayer.typeconverter.ConverterTimeOfDay
import com.example.taskamazing.datalayer.typeconverter.ConverterTypeOfTask
import com.example.taskamazing.datalayer.typeconverter.TimeConverter
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Database
    (entities = [TaskImage::class, Task::class, User::class], version = 1)

@TypeConverters(TimeConverter::class, ConverterTimeOfDay::class, ConverterTypeOfTask::class,ConverterEnvironment::class)
abstract class LocalDatabase:RoomDatabase() {

    abstract fun getUserDao(): DaoUser
    abstract fun getTaskImageDao(): DaoTaskImage
    abstract fun getTaskDao(): DaoTask

    @Module
    @InstallIn(SingletonComponent::class)
    object LocalDatabaseModule {

        @Provides
        @Singleton
        fun provideLocalDatabase(
            @ApplicationContext context: Context
        ): LocalDatabase {
            return Room.databaseBuilder(
                context,
                LocalDatabase::class.java,
                "LocalDatabase"
            ).build()
        }

        @Provides
        fun provideDaoUser(db: LocalDatabase): DaoUser = db.getUserDao()

        @Provides
        fun provideDaoTaskImage(db: LocalDatabase): DaoTaskImage = db.getTaskImageDao()

        @Provides
        fun provideDaoTask(db: LocalDatabase): DaoTask = db.getTaskDao()
    }
}