package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Actividad 1",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Seleccionar Anime",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(
            onClick = {}
        ) {
            Text(text = "Ingresar a Mundo Pokemon")
        }

        Button(
            onClick = {}
        ) {
            Text(text = "Ingresar a Mundo DragonBall")
        }

    }
}