package be.dilibel.pokedex_app.network

import be.dilibel.pokedex_app.entities.Pokedex
import be.dilibel.pokedex_app.entities.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon?limit=151")
    suspend fun getPokedex(): Pokedex

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon
}
