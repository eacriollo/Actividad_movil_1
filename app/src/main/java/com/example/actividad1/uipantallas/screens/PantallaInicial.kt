package com.example.actividad1.uipantallas.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.actividad1.uipantallas.components.BotonCategoria
import com.example.actividad1.viewmodel.HomeViewModel
import androidx.compose.ui.res.stringResource
import com.example.actividad1.R


//pantalla inicial de la aplicación donde se selecciona el anime a ver
@Composable
fun PantallaInicial (
    irAListado: (String) -> Unit,
    viewModel: HomeViewModel = viewModel()
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    //pantalla inical de la aplicación
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.titulo_inicio),
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = stringResource(id = R.string.descripcion_inicio),
            style = MaterialTheme.typography.bodyLarge
        )

        uiState.categorias.forEach { categoria ->
            BotonCategoria(
                texto = stringResource(id = categoria.titulo),
                descripcion = categoria.descripcion,
                colorFondo = if (categoria.id == "pokemon") {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.secondary
                },
                onClick = {
                    irAListado(categoria.id)
                }
            )
        }


    }
}
