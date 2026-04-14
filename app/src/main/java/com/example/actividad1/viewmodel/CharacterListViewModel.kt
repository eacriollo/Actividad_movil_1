package com.example.actividad1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actividad1.model.Personaje
import com.example.actividad1.repository.DragonBallRepository
import com.example.actividad1.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


data class CharacterListUiState(
    val isLoading: Boolean = false,
    val personajes: List<Personaje> = emptyList(),
    val errorMessage: String? = null
)
class CharacterListViewModel : ViewModel() {

    private val pokemonRepository = PokemonRepository()
    private val dragonBallRepository = DragonBallRepository()

    private val _uiState = MutableStateFlow(CharacterListUiState())
    val uiState: StateFlow<CharacterListUiState> = _uiState.asStateFlow()


    fun cargarPersonajes(categoria: String) {
        viewModelScope.launch {
            _uiState.value = CharacterListUiState(isLoading = true)

            try {
                val personajes = if (categoria == "pokemon") {
                    pokemonRepository.obtenerPokemons()


            } else {
                dragonBallRepository.obtenerPersonajes()
            }

                _uiState.value = CharacterListUiState(
                    isLoading = false,
                    personajes = personajes,
                    errorMessage = null
                )
            } catch (e: Exception) {
                _uiState.value = CharacterListUiState(
                    isLoading = false,
                    personajes = emptyList(),
                    errorMessage = e.message ?: "Error desconocido"
                )
            }
        }

    }



}





