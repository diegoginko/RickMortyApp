package com.diegoginko.rickmortyapp.domain

import com.diegoginko.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}