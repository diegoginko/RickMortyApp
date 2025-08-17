package com.diegoginko.rickmortyapp.di

import com.diegoginko.rickmortyapp.data.database.RickMortyDatabase
import com.diegoginko.rickmortyapp.data.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase> { getDatabase() }
    }
}