package com.diegoginko.rickmortyapp.domain

import com.diegoginko.rickmortyapp.domain.model.CharacterModel
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class GetRandomCharacter(val repository: Repository) {
    //El invoke sirve para que se ejecute la funcion al instanciar la clase
    suspend operator fun invoke(): CharacterModel {

//        val characterDataBase = repository.getSavedCharacter()

//        if (getCurrentDayOfTheYear() == characterDataBase.date) {
//
//        }else{
//
//        }
        repository.getCharacterDB()

        val random: Int = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }

    @OptIn(ExperimentalTime::class)
    private fun getCurrentDayOfTheYear():String{
        val instant : Instant = Clock.System.now()
        val localTime : LocalDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}