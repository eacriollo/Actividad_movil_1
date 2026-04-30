package com.example.actividad1.uipantallas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.actividad1.uipantallas.screens.PantallaDetalle
import com.example.actividad1.uipantallas.screens.PantallaInicial
import com.example.actividad1.uipantallas.screens.PantallaListado


// Navegación de la aplicación utilizando NavDisplay
@Composable
fun AppNavegacion() {
    val backStack = rememberNavBackStack(Inicio)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Inicio> {
                PantallaInicial(
                    irAListado = { categoria ->
                        backStack.add(Listado(categoria))
                    }
                )
            }

            entry<Listado> { destino ->
                PantallaListado(
                    categoria = destino.categoria,
                    irADetalle = { nombre ->
                        backStack.add(
                            Detalle(
                                categoria = destino.categoria,
                                nombre = nombre
                            )
                        )
                    },
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }

            entry<Detalle> { destino ->
                PantallaDetalle(
                    categoria = destino.categoria,
                    nombre = destino.nombre,
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}