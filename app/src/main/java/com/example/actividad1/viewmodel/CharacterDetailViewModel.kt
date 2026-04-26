package com.example.actividad1.viewmodel



import androidx.lifecycle.ViewModel
import com.example.actividad1.model.Personaje
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Estado de la pantalla de detalle.
data class CharacterDetailUiState(
    val personaje: Personaje? = null
)

// ViewModel encargado de exponer el personaje seleccionado en la pantalla de detalle.
class CharacterDetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CharacterDetailUiState())
    val uiState: StateFlow<CharacterDetailUiState> = _uiState.asStateFlow()

    fun cargarPersonaje(personaje: Personaje?) {
        _uiState.value = CharacterDetailUiState(personaje = personaje)
    }
}
