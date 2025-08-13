package com.diegoginko.rickmortyapp.ui.home.tabs.characters

import com.diegoginko.rickmortyapp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null
)
