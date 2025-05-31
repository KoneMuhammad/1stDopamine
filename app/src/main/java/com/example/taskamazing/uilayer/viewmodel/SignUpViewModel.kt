package com.example.taskamazing.uilayer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskamazing.datalayer.domainmodel.ModelUser
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseUserRepository
import com.example.taskamazing.errorhandler.ErrorHandleObject
import com.example.taskamazing.errorhandler.errorHandleMessage
import io.ktor.client.plugins.ClientRequestException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

data class SignUpUiState(
    val errorMessage: List<ErrorHandleObject> = emptyList(),
    val loading: Boolean = false,
    val success: Boolean = false
)
class SignUpViewModel@Inject constructor(private val supabaseUserRepository: SupabaseUserRepository):ViewModel() {

    private val _SignUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState: StateFlow<SignUpUiState> = _SignUpUiState.asStateFlow()

    fun createNewUser(email: String, password: String, user: ModelUser) {
        viewModelScope.launch {
            _SignUpUiState.update {
                it.copy(loading = true)
            }
            try {
                supabaseUserRepository.addNewUser(email,password)
                supabaseUserRepository.upsertNewUser(user)
                _SignUpUiState.update {
                    it.copy(success = true)
                }

            }
            catch (e: ClientRequestException){
                _SignUpUiState.update {
                    it.copy(errorMessage = errorHandleMessage(e))
                }
            }
            catch (e: IOException){
                _SignUpUiState.update {
                    it.copy(errorMessage = errorHandleMessage(e))
                }
            }
        }
    }
}
