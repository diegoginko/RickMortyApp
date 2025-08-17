package com.diegoginko.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import com.diegoginko.rickmortyapp.domain.model.CharacterOfTheDayModel

@Entity(tableName = "character_of_the_day")
data class CharacterOfTheDayEntity(
    @PrimaryKey val id: Int,
    val isAlive: Boolean,
    val name: String,
    val image: String,
    val selectedDate:String
) {
    fun toDomain(): CharacterOfTheDayModel? {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                isAlive = isAlive,
                name = name,
                image = image
            ),
            selectedDay = selectedDate
        )
    }
}
