package com.diegoginko.rickmortyapp.domain

import app.cash.paging.PagingData
import com.diegoginko.rickmortyapp.data.database.entity.CharacterOfTheDayEntity
import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import com.diegoginko.rickmortyapp.domain.model.CharacterOfTheDayModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel)
}