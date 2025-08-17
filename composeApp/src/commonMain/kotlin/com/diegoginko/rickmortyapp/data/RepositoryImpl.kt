package com.diegoginko.rickmortyapp.data

import app.cash.paging.PagingData
import com.diegoginko.rickmortyapp.data.database.RickMortyDatabase
import com.diegoginko.rickmortyapp.data.remote.ApiService
import com.diegoginko.rickmortyapp.data.remote.paging.CharactersPagingSource
import com.diegoginko.rickmortyapp.domain.Repository
import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(private val api: ApiService, private val CharacterPagingSource: CharactersPagingSource, private val rickMortyDatabase: RickMortyDatabase): Repository {
    companion object{
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 4
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return _root_ide_package_.app.cash.paging.Pager(
            config = _root_ide_package_.app.cash.paging.PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {CharacterPagingSource}
        ).flow
    }

    override suspend fun getCharacterDB(): Flow<CharacterModel> {
        rickMortyDatabase.getPreferecesDao().getCharacterOfTheDayDB()
    }
}
