package be.dilibel.pokedex_app.repositories

import be.dilibel.pokedex_app.entities.Pokedex
import be.dilibel.pokedex_app.entities.Pokemon
import be.dilibel.pokedex_app.network.PokemonService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object PokemonRepository {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: PokemonService = retrofit.create(PokemonService::class.java)

    suspend fun getPokedex(): Pokedex {
        val listPokemon = mutableListOf<Pokemon>()
        var pokemon: Pokemon
        repeat(898) { index ->
            pokemon = getPokemon(index + 1)
            listPokemon.add(pokemon)
        }
        val pokedex = Pokedex()
        pokedex.listPokemons = listPokemon
        return pokedex
    }

    suspend fun getPokemon(id: Int): Pokemon {
        return retrofitService.getPokemon(id)
    }
}