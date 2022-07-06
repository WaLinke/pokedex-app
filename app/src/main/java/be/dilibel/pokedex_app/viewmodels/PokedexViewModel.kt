package be.dilibel.pokedex_app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.dilibel.pokedex_app.entities.Pokedex
import be.dilibel.pokedex_app.entities.Pokemon
import be.dilibel.pokedex_app.entities.PokemonDescription
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

    private val _description = MutableLiveData<PokemonDescription?>()
    val description: LiveData<PokemonDescription?> = _description


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
                Log.e("EXCEPTION", e.toString())
            }
            Log.e("API_REQUEST", _status.value.toString())
        }
    }

    fun getPokemonDescription(id: Int) {
        viewModelScope.launch {
            _status.value = PokemonApiStatus.LOADING
            try {
                _description.value = PokemonRepository.getPokemonDescription(id)
                _status.value = PokemonApiStatus.DONE
            } catch (e: Exception) {
                _description.value = null
                _status.value = PokemonApiStatus.ERROR
                Log.e("EXCEPTION", e.toString())
            }
            Log.e("API_REQUEST", _status.value.toString())
        }
    }

    fun setCurrentPokemon(currentPokemon: Pokemon) {
        _currentPokemon.value = currentPokemon
    }

}