package com.example.actividad1.viewmodel

import android.R.attr.text
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.actividad1.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Modelo de UI para cada opción mostrada en la pantalla inicial.
data class CategoriaUiState(
    val id: String,
    val titulo: Int,
    val descripcion: String
)

// Estado de la pantalla inicial.
data class HomeUiState(
    val categorias: List<CategoriaUiState> = listOf(
        CategoriaUiState(
            id = "pokemon",
            titulo = R.string.ver_pokemon,
            descripcion = "Explora personajes y consulta sus detalles."
        ),
        CategoriaUiState(
            id = "dragonball",
            titulo = R.string.ver_dragonball,
            descripcion = "Descubre guerreros y consulta información del universo Dragon Ball."
        )


    )
)

// ViewModel de la pantalla inicial.
class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}
