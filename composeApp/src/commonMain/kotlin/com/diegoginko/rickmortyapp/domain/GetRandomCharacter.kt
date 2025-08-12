package com.diegoginko.rickmortyapp.domain

import com.diegoginko.rickmortyapp.domain.model.CharacterModel

class GetRandomCharacter(val repository: Repository) {
    //El invoke sirve para que se ejecute la funcion al instanciar la clase
    suspend operator fun invoke(): CharacterModel {
        val random: Int = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }
}