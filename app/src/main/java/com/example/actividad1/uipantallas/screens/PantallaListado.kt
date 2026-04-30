package com.example.actividad1.uipantallas.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.actividad1.R
import com.example.actividad1.uipantallas.SelectedCharacterStore
import com.example.actividad1.uipantallas.components.BotonCategoria
import com.example.actividad1.uipantallas.components.TarjetaPersonaje
import com.example.actividad1.viewmodel.CharacterListViewModel

// Composable para la pantalla de listado de personajes
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaListado(
    categoria: String,
    irADetalle: (String) -> Unit,
    onBack: () -> Unit,
    viewModel: CharacterListViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var textoBusqueda by remember { mutableStateOf("") }

    LaunchedEffect(categoria) {
        viewModel.cargarPersonajes(categoria)
    }

    val personajesFiltrados = uiState.personajes.filter { personaje ->
        personaje.nombre.contains(textoBusqueda, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Listado de $categoria")
                },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text(text = stringResource(R.string.volver))
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = textoBusqueda,
                onValueChange = { textoBusqueda = it },
                label = { Text(text = stringResource(R.string.buscar_personaje)) },
                modifier = Modifier.fillMaxWidth()
            )

            when {
                uiState.isLoading -> {
                    Text(text = stringResource(R.string.cargando_personajes))
                }

                uiState.errorMessage != null -> {
                    Text(text = uiState.errorMessage!!)
                }

                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(personajesFiltrados) { personaje ->
                            TarjetaPersonaje(
                                personaje = personaje,
                                onClick = {
                                    SelectedCharacterStore.personajeSeleccionado = personaje
                                    irADetalle(personaje.nombre)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
