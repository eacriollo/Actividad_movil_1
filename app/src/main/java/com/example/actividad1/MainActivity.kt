package com.example.actividad1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.actividad1.ui.theme.Actividad1Theme
import com.example.actividad1.uipantallas.AppNavegacion


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad1Theme {

                    AppNavegacion()

            }
        }
    }
}

