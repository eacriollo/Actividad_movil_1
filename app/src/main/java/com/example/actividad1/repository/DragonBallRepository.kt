package com.example.actividad1.repository

import com.example.actividad1.model.Personaje
import com.example.actividad1.network.DragonBallRetrofitInstance

class DragonBallRepository {

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