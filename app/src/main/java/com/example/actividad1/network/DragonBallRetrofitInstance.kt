package com.example.actividad1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Instancia de Retrofit para la API de Dragon Ball
object DragonBallRetrofitInstance {

    private const val BASE_URL = "https://dragonball-api.com/api/"

    val api: DragonBallApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DragonBallApiService::class.java)

    }

}