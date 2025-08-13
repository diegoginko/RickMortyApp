package com.diegoginko.rickmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoginko.rickmortyapp.domain.GetRandomCharacter
import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersViewModel(val getRandomCharacter: GetRandomCharacter): ViewModel() {
    //Dejo el estado mutable como privado para que no se modifique desde otro lado, solo del viewModel
    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    //Creo la variable para accederla desde el composable
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            val result : CharacterModel = withContext(Dispatchers.IO){
                getRandomCharacter()

            }
            _state.update { it.copy(characterOfTheDay = result) }

        }
    }
}