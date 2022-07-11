package be.dilibel.pokedex_app.fragments

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.palette.graphics.Palette
import androidx.viewpager2.widget.ViewPager2
import be.dilibel.pokedex_app.R
import be.dilibel.pokedex_app.adapters.PokemonTabAdapter
import be.dilibel.pokedex_app.databinding.FragmentPokemonBinding
import be.dilibel.pokedex_app.utils.PokemonUtils
import be.dilibel.pokedex_app.viewmodels.PokedexViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.*
import java.net.URL


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
        viewModel.currentPokemon.value?.let { viewModel.getPokemonDescription(it.id) }
        val tabLayout: TabLayout = view.findViewById(R.id.pokemonTabLayout)
        val viewPager: ViewPager2 = view.findViewById(R.id.pokemonViewPager)
        viewPager.isUserInputEnabled = false
        viewPager.adapter = PokemonTabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager, true, false) { tab, position ->
            tab.text = when (position) {
                0 -> "About"
                1 -> "Stats"
                2 -> "Moves"
                else -> throw Resources.NotFoundException("Position not found")
            }
        }.attach()
        val leftArrow: ImageView = view.findViewById(R.id.leftArrow)
        leftArrow.setOnClickListener {
            findNavController().navigateUp()

        }
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.currentPokemon.value?.img?.let { PokemonUtils.setPokemonDominantColor(it, view, context) }
        }
    }


}