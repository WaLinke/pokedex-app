package be.dilibel.pokedex_app.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.palette.graphics.Palette
import be.dilibel.pokedex_app.R
import java.net.URL


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
        fun setPokemonDominantColor(imageUrl: String, view: View) {
            try {
                val url = URL(imageUrl)
                val image = BitmapFactory.decodeStream(url.openStream())
                Palette.from(image).generate { palette: Palette? ->
                    val vibrant = palette?.dominantSwatch
                    val textView: TextView = view.findViewById(R.id.pokemonDescription) as TextView
                    if (vibrant != null) {
                        textView.getBackground().colorFilter =
                            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(vibrant.rgb, BlendModeCompat.SRC_ATOP)
                    };
                }
            } catch (e: Exception) {}
        }
    }
}