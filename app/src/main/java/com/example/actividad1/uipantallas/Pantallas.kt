package com.example.actividad1.uipantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad1.model.Personaje
import com.example.actividad1.network.RetrofitInstance
import com.example.actividad1.network.DragonBallRetrofitInstance
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.setValue
import com.example.actividad1.viewmodel.CharacterListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import coil.compose.AsyncImage


@Composable
fun PantallaInicial (
    irAListado: (String) -> Unit
){
    //pantalla inical de la aplicación
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Actividad 1",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Seleccionar Anime",
            style = MaterialTheme.typography.bodyLarge
        )

        BotonCategoria(
            text = "Ver Mundo Pokemon",
            onClick = {
                irAListado("pokemon")
            }
        )
        BotonCategoria(
            text = "Ver Mundo Dragon Ball",
            onClick = {
                irAListado("dragonball")
            }
        )



    }
}

@Composable
fun BotonCategoria(
    text: String,
    onClick: () -> Unit,

    ){
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),

        ) {
        Text(text = text)
    }
}


@Composable
fun PantallaListado(
    categoria: String,
    irADetalle: (String) -> Unit,
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Pantalla de listado",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Categoría seleccionada: $categoria",
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedTextField(
            value = textoBusqueda,
            onValueChange = { textoBusqueda = it },
            label = { Text("Buscar personaje") },
            modifier = Modifier.fillMaxWidth()
        )

        when {
            uiState.isLoading -> {
                Text(text = "Cargando personajes...")
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
@Composable
fun TarjetaPersonaje(
    personaje: Personaje,
    onClick: () -> Unit
){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onClick() }

    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = personaje.imagen,
                contentDescription = personaje.nombre,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = personaje.nombre,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = personaje.descripcion,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}

@Composable
fun PantallaDetalle(
    categoria: String,
    nombre: String
) {
    val personaje = SelectedCharacterStore.personajeSeleccionado

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Detalle del personaje",
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
