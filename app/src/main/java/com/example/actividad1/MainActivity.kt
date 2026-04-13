package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad1.ui.theme.Actividad1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad1Theme {

                    PantallaInicial()

            }
        }
    }
}





@Composable
fun PantallaInicial (){
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
            onClick = {  }
        )
        BotonCategoria(
            text = "Ver Mundo Dragon Ball",
            onClick = {  }
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

