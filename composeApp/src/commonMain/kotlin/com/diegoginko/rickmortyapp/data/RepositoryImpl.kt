package com.diegoginko.rickmortyapp.data

import com.diegoginko.rickmortyapp.data.remote.ApiService
import com.diegoginko.rickmortyapp.domain.Repository
import com.diegoginko.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(private val api: ApiService): Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }
}
