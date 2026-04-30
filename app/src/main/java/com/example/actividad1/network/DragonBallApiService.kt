package com.example.actividad1.network


import retrofit2.http.GET
import retrofit2.http.Query


// Interfaz para la API de Pokemon
interface DragonBallApiService{
    @GET("characters")
    suspend fun obtenerPersonajes(
        @Query("limit") limite: Int = 20
    ): DragonBallResponse

}

// Modelo de datos para la respuesta de la API de Dragon Ball
data class DragonBallResponse(
    val items: List<DragonBallCharacter>
)

// Modelo de datos para un personaje de Dragon Ball
data class DragonBallCharacter(
    val id: Int,
    val name: String,
    val description: String?,
    val image: String?
)

