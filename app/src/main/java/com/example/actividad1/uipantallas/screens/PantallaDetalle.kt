package com.example.actividad1.uipantallas.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.actividad1.uipantallas.SelectedCharacterStore
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.actividad1.viewmodel.CharacterDetailViewModel
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.ui.res.stringResource
import com.example.actividad1.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalle(
    categoria: String,
    nombre: String,
    onBack: () -> Unit,
    viewModel: CharacterDetailViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.cargarPersonaje(SelectedCharacterStore.personajeSeleccionado)
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val personaje = uiState.personaje

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detalle")
                },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text( text =  stringResource(R.string.volver))
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.detalle_personaje),
                style = MaterialTheme.typography.headlineMedium
            )

            AsyncImage(
                model = personaje?.imagen,
                contentDescription = nombre,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Nombre: $nombre",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Categoría: $categoria",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Descripción: ${personaje?.descripcion ?: "Sin descripción"}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
