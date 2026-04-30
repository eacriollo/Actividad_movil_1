package com.example.actividad1.network

import retrofit2.http.GET
import retrofit2.http.Query

// Interfaz para la API de Pokemon
interface PokeApiService{

    // Funciones para obtener los pokemons de la API de pokemon
    @GET("pokemon")
    suspend fun obtenerPokemons(
        @Query("limit") limite: Int = 20
    ): PokemonListResponse

}

// Modelo de datos para la respuesta de la API de Pokemon
data class PokemonListResponse(
    val results: List<PokemonResult>
)

// Modelo de datos para un pokemon
data class PokemonResult(
    val name: String,
    val url: String
)



