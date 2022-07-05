package be.dilibel.pokedex_app.utils

import android.util.Log
import be.dilibel.pokedex_app.R

class PokemonUtils {
    companion object {
        fun getTypeIcon(typeName : String) : Int {
            val typeIcon : Int
            when (typeName) {
                "bug" -> typeIcon = R.drawable.bug
                "dark" -> typeIcon = R.drawable.dark
                "dragon" -> typeIcon = R.drawable.dragon
                "electric" -> typeIcon = R.drawable.electric
                "fairy" -> typeIcon = R.drawable.fairy
                "fighting" -> typeIcon = R.drawable.fighting
                "fire" -> typeIcon = R.drawable.fire
                "flying" -> typeIcon = R.drawable.flying
                "ghost" -> typeIcon = R.drawable.ghost
                "grass" -> typeIcon = R.drawable.grass
                "ground" -> typeIcon = R.drawable.ground
                "ice" -> typeIcon = R.drawable.ice
                "normal" -> typeIcon = R.drawable.normal
                "poison" -> typeIcon = R.drawable.poison
                "psychic" -> typeIcon = R.drawable.psychic
                "rock" -> typeIcon = R.drawable.rock
                "steel" -> typeIcon = R.drawable.steel
                "water" -> typeIcon = R.drawable.water
                else -> {
                    typeIcon = R.drawable.steel
                    Log.e("TYPE MISSMATCH",typeName)
                }
            }
            return typeIcon
        }
    }
}