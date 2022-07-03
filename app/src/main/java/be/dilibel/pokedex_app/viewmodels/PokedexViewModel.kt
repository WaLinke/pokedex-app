package be.dilibel.pokedex_app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.dilibel.pokedex_app.entities.Pokedex
import be.dilibel.pokedex_app.entities.Pokemon
import be.dilibel.pokedex_app.repositories.PokemonRepository
import kotlinx.coroutines.launch

enum class PokemonApiStatus { LOADING, ERROR, DONE }

class PokedexViewModel : ViewModel() {
    private val _status = MutableLiveData<PokemonApiStatus>()
    val status: LiveData<PokemonApiStatus> = _status

    private val _pokedex = MutableLiveData<Pokedex?>()
    val pokedex: LiveData<Pokedex?> = _pokedex

    private val _currentPokemon = MutableLiveData<Pokemon?>()
    val currentPokemon: LiveData<Pokemon?> = _currentPokemon

    init {
        getPokedex()
        _currentPokemon.value = null
    }

    private fun getPokedex() {
        viewModelScope.launch {
            _status.value = PokemonApiStatus.LOADING
            try {
                _pokedex.value = PokemonRepository.getPokedex()
                _status.value = PokemonApiStatus.DONE
            } catch (e: Exception) {
                _pokedex.value = null
                _status.value = PokemonApiStatus.ERROR
            }
            Log.e("API_REQUEST", _status.toString())
        }
    }

    fun setCurrentPokemon(currentPokemon: Pokemon) {
        _currentPokemon.value = currentPokemon
    }

}