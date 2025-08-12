package com.diegoginko.rickmortyapp.data.remote.response

import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id : Int,
    val name : String,
    val status : String,
    val species : String,
    val type : String,
    val gender : String,
    val image : String,
    val episode : List<String>,
    val url : String,
    @SerialName("created")
    val created : String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            isAlive = status.lowercase() == "alive",
            species = species,
            type = type,
            gender = gender,
            image = image,
            episode = episode
        )
    }
}