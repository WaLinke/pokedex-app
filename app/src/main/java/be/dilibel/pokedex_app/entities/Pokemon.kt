package be.dilibel.pokedex_app.entities

import com.squareup.moshi.Json
import java.util.*

data class Pokemon(
        @Json(name = "id") val id: Int,
        @Json(name = "name") var name: String,
        @Json(name="types") val types: List<PokemonTypesResponse>,
        val img: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png"
)

data class PokemonTypesResponse(
        @Json(name = "type") val type: PokemonTypes
)

data class PokemonTypes(
        @Json(name = "name") val typeName: String
)