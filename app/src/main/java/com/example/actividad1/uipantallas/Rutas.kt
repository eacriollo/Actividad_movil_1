package com.example.actividad1.uipantallas

object Rutas {
    const val INICIO = "inicio"
    const val LISTADO = "listado/{categoria}"
    const val DETALLE = "detalle/{categoria}/{nombre}"

    fun listado(categoria: String): String {
        return "listado/$categoria"
    }

    fun detalle(categoria: String, nombre: String): String {
        return "detalle/$categoria/$nombre"

    }

}