package com.diegoginko.rickmortyapp.domain.model

import com.diegoginko.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDay: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            isAlive = characterModel.isAlive,
            name = characterModel.name,
            image = characterModel.image,
            selectedDate = selectedDay
        )
    }
}
