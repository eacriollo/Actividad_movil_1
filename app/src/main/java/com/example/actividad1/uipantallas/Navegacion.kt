package com.example.actividad1.uipantallas

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad1.uipantallas.PantallaDetalle
import com.example.actividad1.uipantallas.PantallaInicial
import com.example.actividad1.uipantallas.PantallaListado

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        composable("inicio") {
            PantallaInicial(
                irAListado = { categoria ->
                    navController.navigate("listado/$categoria")
                }
            )
        }

        composable("listado/{categoria}") { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: ""
            // Aquí puedes manejar la categoría seleccionada y mostrar el contenido correspondiente
            PantallaListado(
                categoria = categoria,
                irADetalle = { nombre ->
                    navController.navigate("detalle/$categoria/$nombre")
                }
            )
        }
        composable("detalle/{categoria}/{nombre}") { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: ""
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            //manejar la categoría seleccionada y mostrar el contenido correspondiente
            PantallaDetalle(
                categoria = categoria,
                nombre = nombre
            )
        }
    }
}
