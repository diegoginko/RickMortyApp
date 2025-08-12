package com.diegoginko.rickmortyapp.data.remote.response

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
)