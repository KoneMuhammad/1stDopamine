package com.example.taskamazing.uilayer.viewmodel

import android.content.Context
import android.location.Location
import android.location.LocationProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.dto.SimplifiedWeather
import com.example.taskamazing.datalayer.enumclass.weather_type
import com.example.taskamazing.datalayer.mapper.weatherTypeToDto
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseTaskMessageRepository
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseTaskWeatherRepository
import com.example.taskamazing.datalayer.repository.weatherapirepository.WeatherRepository
import com.example.taskamazing.errorhandler.ErrorHandleObject
import com.example.taskamazing.errorhandler.errorHandleMessage
import com.example.taskamazing.locationbuilder.getCurrentLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TaskUiState(
    val modelTaskWeather: ModelDTOTaskWeatherBackground? = null,
    val modelTaskMessage: List<ModelDTOTaskMessage> = emptyList(),
    val message: List<ErrorHandleObject> = emptyList(),
    val currentWeatherType: SimplifiedWeather? = null,
)

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val supabaseTaskMessageRepository: SupabaseTaskMessageRepository,
    private val supabaseTaskWeatherRepository: SupabaseTaskWeatherRepository,
    private val weatherRepository: WeatherRepository,
) : ViewModel() {


    private val _uiState = MutableStateFlow(TaskUiState())
    val uiState: StateFlow<TaskUiState> = _uiState.asStateFlow()

    //GETS TYPE OF WEATHER TEXT == FOGGY == UPDATE IT TO CURRENT
     fun LoadWeatherType(latitude: String,longitude: String, apiKey: String) {
        viewModelScope.launch() {
            try {
                weatherRepository.fetchWeather(latitude, longitude, apiKey)
                    // need to collect form the cold flow
                    .collect { weather ->
                        _uiState.update {
                            it.copy(
                                currentWeatherType = weather

                            )
                        }
                    }
            } catch (e: ServerResponseException) {
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }
            }
        }
    }

    //GETS WEATHER-TYPE AND WEATHER VIDEO == UPDATE TO CURRENT
    fun getWeatherBackground(weatherType: weather_type?) {
        viewModelScope.launch {
            try {
                supabaseTaskWeatherRepository.getTaskWeather(weatherType!!)
                    .collect { weatherBackground ->
                        _uiState.update {
                            it.copy(
                                modelTaskWeather = weatherBackground
                            )
                        }
                    }//do a mapper based onthat
            } catch (e: ServerResponseException) {
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }

            }
        }
    }

    //keep state
    //
    fun swipeForNextCard(ids: Set<Long>) {
        viewModelScope.launch {
            try {
                supabaseTaskMessageRepository.getMultipleTaskMessage(ids)
                    .collect { taskmessage ->
                        _uiState.update {
                            it.copy(
                                modelTaskMessage = taskmessage
                            )
                        }
                    }
            } catch (e: ServerResponseException) {
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }

            }
        }
    }
}




