package com.diegoginko.rickmortyapp.di

import com.diegoginko.rickmortyapp.ui.home.tabs.characters.CharactersViewModel
import com.diegoginko.rickmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)

}