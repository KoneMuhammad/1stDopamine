package com.example.taskamazing.uilayer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseTaskMessageRepository
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseTaskWeatherRepository
import com.example.taskamazing.errorhandler.ErrorHandleObject
import com.example.taskamazing.errorhandler.errorHandleMessage
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


data class TaskUiState(
    val modelTaskWeather: List<ModelDTOTaskWeatherBackground> = emptyList(),
    val modelTaskMessage: List<ModelDTOTaskMessage> = emptyList(),
    val message: List<ErrorHandleObject> = emptyList()
)

//addd a dark/lighttheme preference in top right of screen
class TaskViewModel@Inject constructor(private val supabaseTaskMessageRepository: SupabaseTaskMessageRepository,
    private val supabaseTaskWeatherRepository: SupabaseTaskWeatherRepository): ViewModel() {

        //return  type viewmodel
    private val _uiState = MutableStateFlow(TaskUiState())
    val uiState:StateFlow<TaskUiState> = _uiState.asStateFlow()

    fun swipeForNextCard(ids: Set<Long>){
        viewModelScope.launch {
            try {
                combine(supabaseTaskWeatherRepository.getMultipleTaskWeather(ids),
                    supabaseTaskMessageRepository.getMultipleTaskMessage(ids)){
                    taskWeather, taskMessage -> _uiState.update {
                        it.copy(
                            modelTaskWeather = taskWeather,
                            modelTaskMessage = taskMessage
                        )
                }
                }

            }catch (e: ServerResponseException){
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }
            }
            catch (e: Exception){
                _uiState.update {
                    it.copy(message = errorHandleMessage(e))
                }

            }
        }
    }
}