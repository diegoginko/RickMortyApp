package com.diegoginko.rickmortyapp.ui.home.tabs.characters

import androidx.paging.PagingData
import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null,
    val characters: Flow<PagingData<CharacterModel>>? = null
)
