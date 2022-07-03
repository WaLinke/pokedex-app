package be.dilibel.pokedex_app.adapters

import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import be.dilibel.pokedex_app.R
import be.dilibel.pokedex_app.databinding.PokemonCardItemBinding
import be.dilibel.pokedex_app.entities.Pokemon
import be.dilibel.pokedex_app.fragments.PokedexFragment
import be.dilibel.pokedex_app.viewmodels.PokedexViewModel


class PokemonGridAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Pokemon, PokemonGridAdapter.PokemonImageViewHolder>(DiffCallback) {

    class PokemonImageViewHolder(
        private var binding: PokemonCardItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {
            binding.pokemon = pokemon
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.img == newItem.img
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonImageViewHolder {
        return PokemonImageViewHolder(
            PokemonCardItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: PokemonImageViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(pokemon)
        }
        holder.bind(pokemon)
    }

    class OnClickListener(val clickListener: (pokemon: Pokemon) -> Unit) {
        fun onClick(pokemon: Pokemon) = clickListener(pokemon)
    }
}