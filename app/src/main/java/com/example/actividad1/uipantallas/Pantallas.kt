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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad1.model.Personaje




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
    irADetalle: (String) -> Unit
) {
    val personajes = if (categoria == "pokemon") {
        listOf(
            Personaje("Pikachu", "Pokemon eléctrico muy popular"),
            Personaje("Charmander", "Pokemon de tipo fuego"),
            Personaje("Bulbasaur", "Pokemon de tipo planta"),
            Personaje("Squirtle", "Pokemon de tipo agua")
        )
    } else {
        listOf(
            Personaje("Goku", "Guerrero saiyajin y protagonista"),
            Personaje("Vegeta", "Príncipe de los saiyajin"),
            Personaje("Piccolo", "Guerrero namekiano"),
            Personaje("Gohan", "Hijo de Goku")
        )
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

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(personajes) { personaje ->
                TarjetaPersonaje(
                    personaje = personaje,
                    onClick = {
                        irADetalle(personaje.nombre)
                    }
                )
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
    val descripcion = if (categoria == "pokemon") {
        when (nombre) {
            "Pikachu" -> "Pokemon eléctrico muy popular"
            "Charmander" -> "Pokemon de tipo fuego"
            "Bulbasaur" -> "Pokemon de tipo planta"
            "Squirtle" -> "Pokemon de tipo agua"
            else -> "Sin descripción"
        }
    } else {
        when (nombre) {
            "Goku" -> "Guerrero saiyajin y protagonista"
            "Vegeta" -> "Príncipe de los saiyajin"
            "Piccolo" -> "Guerrero namekiano"
            "Gohan" -> "Hijo de Goku"
            else -> "Sin descripción"
        }
    }

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

        Text(
            text = "Nombre: $nombre",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Categoría: $categoria",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Descripción: $descripcion",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
