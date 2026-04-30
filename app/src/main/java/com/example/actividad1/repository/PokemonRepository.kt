package com.example.actividad1.repository

import com.example.actividad1.model.Personaje
import com.example.actividad1.network.RetrofitInstance
// Repositorio para obtener los Pokémon desde la API
class PokemonRepository {


    suspend fun obtenerPokemons(): List<Personaje> {
        val respuesta = RetrofitInstance.api.obtenerPokemons()

        return respuesta.results.map { pokemon ->
            Personaje(
                nombre = pokemon.name,
                descripcion = "Pokemon obtenido desde la API",
                imagen = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" +
                        pokemon.url.trimEnd('/').substringAfterLast('/') + ".png"

            )

        }
    }
}