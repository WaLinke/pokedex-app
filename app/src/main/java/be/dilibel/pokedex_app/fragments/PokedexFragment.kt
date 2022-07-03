package be.dilibel.pokedex_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import be.dilibel.pokedex_app.R
import be.dilibel.pokedex_app.adapters.PokemonGridAdapter
import be.dilibel.pokedex_app.databinding.FragmentPokedexBinding
import be.dilibel.pokedex_app.entities.Pokemon
import be.dilibel.pokedex_app.viewmodels.PokedexViewModel

class PokedexFragment : Fragment() {

    private val viewModel: PokedexViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPokedexBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PokemonGridAdapter(PokemonGridAdapter.OnClickListener { pokemon ->
            viewModel.setCurrentPokemon(pokemon)
            findNavController().navigate(R.id.action_pokedexFragment_to_pokemonFragment)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}