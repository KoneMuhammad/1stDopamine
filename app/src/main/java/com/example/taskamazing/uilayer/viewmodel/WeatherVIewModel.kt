package com.example.taskamazing.uilayer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskamazing.datalayer.apiservice.DTOCurrentWeather
import com.example.taskamazing.datalayer.repository.weatherapirepository.WeatherRepository
import com.example.taskamazing.datalayer.repository.weatherapirepository.WeatherResult
import com.example.taskamazing.errorhandler.ErrorHandleObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class WeatherUIState(
    val weatherType: List<DTOCurrentWeather> = emptyList(),  //default values let the ui render loading states
    val messages: List<ErrorHandleObject> = emptyList()     //messages error are included in the state
)

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherResult = MutableStateFlow<WeatherResult?>(null)
    val weatherResult: StateFlow<WeatherResult?> = _weatherResult.asStateFlow()

    fun loadWeather(location: String, apiKey: String) {
        viewModelScope.launch{
            val result = repository.fetchWeather(location, apiKey)
            _weatherResult.value = result
        }
    }
}
//making the users latandlon into the location of the load weather fun becuase the users.latandlom
//is still going to be reactice despiteit being not in a stateflow

//weatherType to be automatically reactive. along with the weawthertablevideo
//combine in repository
//