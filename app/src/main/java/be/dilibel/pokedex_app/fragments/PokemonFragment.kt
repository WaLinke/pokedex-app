package be.dilibel.pokedex_app.fragments

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import be.dilibel.pokedex_app.R
import be.dilibel.pokedex_app.adapters.PokemonTabAdapter
import be.dilibel.pokedex_app.databinding.FragmentPokemonBinding
import be.dilibel.pokedex_app.utils.PokemonUtils
import be.dilibel.pokedex_app.viewmodels.PokedexViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PokemonFragment : Fragment() {

    private val viewModel: PokedexViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPokemonBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout: TabLayout = view.findViewById(R.id.pokemonTabLayout)
        val viewPager: ViewPager2 = view.findViewById(R.id.pokemonViewPager)
        viewPager.adapter = PokemonTabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "About"
                1 -> "Stats"
                2 -> "Moves"
                else -> throw Resources.NotFoundException("Position not found")
            }
        }.attach()
    }
}