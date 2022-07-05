package be.dilibel.pokedex_app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import be.dilibel.pokedex_app.R
import be.dilibel.pokedex_app.databinding.FragmentPokemonBinding
import be.dilibel.pokedex_app.utils.PokemonUtils
import be.dilibel.pokedex_app.viewmodels.PokedexViewModel


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

        var typeIcon : Int
        val currentPokemon = viewModel.currentPokemon.value

        val firstTypeView = view.findViewById<ImageView>(R.id.ivType1)
        val secondTypeView = view.findViewById<ImageView>(R.id.ivType2)

        if(currentPokemon?.types?.size!! ==  1) {
            secondTypeView.visibility = View.GONE
            firstTypeView?.setImageResource(PokemonUtils.getTypeIcon(currentPokemon.types[0].type.typeName))
        } else {
            firstTypeView?.setImageResource(PokemonUtils.getTypeIcon(currentPokemon.types[0].type.typeName))
            secondTypeView?.setImageResource(PokemonUtils.getTypeIcon(currentPokemon.types[1].type.typeName))
        }
    }
}