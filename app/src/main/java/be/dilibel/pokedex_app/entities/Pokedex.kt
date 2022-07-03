package be.dilibel.pokedex_app.entities

import be.dilibel.pokedex_app.entities.Pokemon
import com.squareup.moshi.Json

data class Pokedex (
    var listPokemons: List<Pokemon> = emptyList()
)