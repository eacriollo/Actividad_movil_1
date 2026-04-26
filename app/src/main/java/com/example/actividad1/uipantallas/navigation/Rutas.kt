package com.example.actividad1.uipantallas.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
data object Inicio : NavKey

@Serializable
data class Listado(
    val categoria: String
) : NavKey

@Serializable
data class Detalle(
    val categoria: String,
    val nombre: String
) : NavKey