package be.dilibel.pokedex_app.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import be.dilibel.pokedex_app.fragments.PokemonAboutFragment
import be.dilibel.pokedex_app.fragments.PokemonFragment
import be.dilibel.pokedex_app.fragments.PokemonMovesFragment
import be.dilibel.pokedex_app.fragments.PokemonStatsFragment

class PokemonTabAdapter(fragmentActivity: PokemonFragment) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {PokemonAboutFragment()}
            1 -> {PokemonStatsFragment()}
            2 -> {PokemonMovesFragment()}
            else -> {throw Resources.NotFoundException("Position not found")}
        }
    }
}