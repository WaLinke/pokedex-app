package be.dilibel.pokedex_app.entities

import com.squareup.moshi.Json
import java.util.*

data class Pokemon(
        @Json(name = "id") val id: Int,
        @Json(name = "name") var name: String,
        @Json(name = "height") val height: Double,
        @Json(name = "weight") val weight: Double,
        @Json(name="types") val types: List<PokemonTypesResponse>,
        @Json(name="stats") val stats: List<PokemonStats>
) {
        val img: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png"
        val formattedName = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val formattedWeight = (weight/10).toString() + " Kg"
        val formattedHeight = (height/10).toString() + " m"
}

data class PokemonTypesResponse(
        @Json(name = "type") val type: PokemonTypes
)

data class PokemonTypes(
        @Json(name = "name") val typeName: String
)

data class PokemonStats(
        @Json(name = "base_stat") val baseStat: Int,
        @Json(name = "stat") val stat: PokemonStat
) {
        val formattedBaseStat = baseStat.toString()
}

data class PokemonStat(
        @Json(name = "name") val name: String
)