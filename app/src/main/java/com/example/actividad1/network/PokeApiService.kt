package com.example.actividad1.network

import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService{

    // Funciones para obtener los pokemons de la API de pokemon
    @GET("pokemon")
    suspend fun obtenerPokemons(
        @Query("limit") limite: Int = 50
    ): PokemonListResponse

}

data class PokemonListResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)



