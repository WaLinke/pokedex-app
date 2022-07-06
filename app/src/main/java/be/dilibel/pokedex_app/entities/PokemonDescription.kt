package be.dilibel.pokedex_app.entities

import com.squareup.moshi.Json
import java.util.*

data class PokemonDescription(
    @Json(name = "flavor_text_entries") val flavorTextEntries: List<FlavorTextEntries>
)

data class FlavorTextEntries(
    @Json(name = "flavor_text") val flavorText: String
) {
    val formattedFlavorText = flavorText.replace("\n"," ")
}