package com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase

import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.enumclass.weather_type
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns

class WrapperImplWeatherSupabase(
    private val client: SupabaseClient
): WrapperWeatherSupabase {
    override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather) {
    }
// either flow or no match data or no get data

    //practice understanding supabase filter s
    override suspend fun getTaskWeather(weatherType: weather_type): ModelDTOTaskWeatherBackground {
        return client
            .from("TaskWeather")
            .select(columns = Columns.list("id, weather_type,video_url")){
                filter { ModelTaskWeather::weather_type eq weatherType.name}
            }//get entire class
            .decodeSingle<ModelDTOTaskWeatherBackground>()
// one time suspend function
    }

    override suspend fun getMultipleTaskWeather(weatherType: Set<weather_type>): List<ModelDTOTaskWeatherBackground> {
        return client
            .from("TaskWeather")
            .select(columns = Columns.list("id, weather_type,video_url")){
                filter { ModelTaskWeather::weather_type isIn weatherType.toList() }
            }

            .decodeList<ModelDTOTaskWeatherBackground>()
    }
}


// whats the current state
//whats function returning
//whats function variabels
