package com.diegoginko.rickmortyapp.data.remote.response

data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>

)
