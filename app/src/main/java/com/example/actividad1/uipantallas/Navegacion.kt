package com.example.actividad1.uipantallas

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.INICIO
    ) {
        composable(Rutas.INICIO) {
            PantallaInicial(
                irAListado = { categoria ->
                    navController.navigate(Rutas.listado(categoria))
                }
            )
        }

        composable(Rutas.LISTADO) { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: ""
            // Aquí puedes manejar la categoría seleccionada y mostrar el contenido correspondiente
            PantallaListado(
                categoria = categoria,
                irADetalle = { nombre ->
                    navController.navigate(Rutas.detalle(categoria, nombre))
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(Rutas.DETALLE) { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: ""
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            //manejar la categoría seleccionada y mostrar el contenido correspondiente
            PantallaDetalle(
                categoria = categoria,
                nombre = nombre,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
