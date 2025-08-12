package com.diegoginko.rickmortyapp.domain.model

data class CharacterModel(
    val id : Int,
    val name : String,
    val isAlive : Boolean,
    val species : String,
    val type : String,
    val gender : String,
    val image : String,
    val episode : List<String>,
)
