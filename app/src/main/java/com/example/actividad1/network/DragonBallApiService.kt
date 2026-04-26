package com.example.actividad1.network


import retrofit2.http.GET
import retrofit2.http.Query

interface DragonBallApiService{
    @GET("characters")
    suspend fun obtenerPersonajes(
        @Query("limit") limite: Int = 50
    ): DragonBallResponse

}

data class DragonBallResponse(
    val items: List<DragonBallCharacter>
)

data class DragonBallCharacter(
    val id: Int,
    val name: String,
    val description: String?,
    val image: String?
)

