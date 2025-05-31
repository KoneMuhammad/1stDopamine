package com.example.taskamazing.datalayer.roombuilder

import android.content.Context
import androidx.room.Room
import com.example.taskamazing.datalayer.dao.DaoTaskMessage
import com.example.taskamazing.datalayer.dao.DaoTaskWeather
import com.example.taskamazing.datalayer.dao.DaoUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



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
        fun provideDaoTaskImage(db: LocalDatabase): DaoTaskWeather = db.getTaskWeatherDao()

        @Provides
        fun provideDaoTask(db: LocalDatabase): DaoTaskMessage = db.getTaskMessageDao()
    }
