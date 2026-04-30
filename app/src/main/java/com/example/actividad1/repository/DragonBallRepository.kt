package com.example.actividad1.repository

import com.example.actividad1.model.Personaje
import com.example.actividad1.network.DragonBallRetrofitInstance

// Repositorio para obtener los personajes de Dragon Ball
class DragonBallRepository {

    // Obtener los personajes de Dragon Ball desde la API
    suspend fun obtenerPersonajes(): List<Personaje> {
        val respuesta = DragonBallRetrofitInstance.api.obtenerPersonajes()

        return respuesta.items.map { personaje ->
            Personaje(
                personaje.name,
                personaje.description ?: "",
                imagen = personaje.image?: ""

            )
        }


    }

}