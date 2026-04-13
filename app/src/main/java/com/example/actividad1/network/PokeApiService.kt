package com.example.actividad1.network

import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService{
    @GET("pokemon")
    suspend fun obtenerPokemons(
        @Query("limit") limite: Int = 20
    ): PokemonListResponse

}

data class PokemonListResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)



