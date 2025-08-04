package com.example.taskamazing.datalayer.builders.roomBuilder

import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperImplMessageSupabase
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperImplUserSupabase
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperImplWeatherSupabase
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperMessageSupabase
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperUserSupabase
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperWeatherSupabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.FlowType
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.realtime.realtime
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SupabaseModule {

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://mgstcpzcjdoxpcbsgfgv.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1nc3RjcHpjamRveHBjYnNnZmd2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDcxMDM2OTksImV4cCI6MjA2MjY3OTY5OX0.oxVGazaUbOxqHpMbrlf42x0tQGXsMdZMwIoQtY2CCsY"
        ) {
            install(Postgrest)
            install(Auth) {
                flowType = FlowType.PKCE
                scheme = "myapp"
                host = "supabase.com"
            }
            install(Storage)
            install(Realtime)
        }
    }


    @Provides
    @Singleton
    fun providePostgrest(client: SupabaseClient): Postgrest {
        return client.postgrest
    }

    @Provides
    @Singleton
    fun provideAuth(client: SupabaseClient): Auth {
        return client.auth
    }

    @Provides
    @Singleton
    fun provideStorage(client: SupabaseClient): Storage {
        return client.storage
    }

    @Provides
    @Singleton
    fun provideRealtime(client: SupabaseClient): Realtime {
        return client.realtime
    }

    @Provides
    @Singleton
    fun provideTaskMessageDataSource(
        client: SupabaseClient
    ): WrapperMessageSupabase {
        return WrapperImplMessageSupabase(client)
    }

    @Provides
    @Singleton
    fun provideTaskWeatherDataSource(
        client: SupabaseClient
    ): WrapperWeatherSupabase {//whenever i call this
        return WrapperImplWeatherSupabase(client)
        //provide this
    }

    @Provides
    @Singleton
    fun provideUserDataSource(
        client: SupabaseClient
    ): WrapperUserSupabase {
        return WrapperImplUserSupabase(client)
    }
}
