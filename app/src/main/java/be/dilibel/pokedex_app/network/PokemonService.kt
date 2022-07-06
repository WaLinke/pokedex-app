package be.dilibel.pokedex_app.network

import be.dilibel.pokedex_app.entities.Pokedex
import be.dilibel.pokedex_app.entities.Pokemon
import be.dilibel.pokedex_app.entities.PokemonDescription
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon

    @GET("pokemon-species/{id}")
    suspend fun getPokemonDescription(@Path("id") id: Int): PokemonDescription
}
