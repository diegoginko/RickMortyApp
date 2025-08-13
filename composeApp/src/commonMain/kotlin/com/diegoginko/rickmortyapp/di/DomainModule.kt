package com.diegoginko.rickmortyapp.di

import com.diegoginko.rickmortyapp.domain.GetName
import com.diegoginko.rickmortyapp.domain.GetRandomCharacter
import com.diegoginko.rickmortyapp.domain.NameOperator
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
//    factory<NameOperator> { NameOperator() }
//    factory<GetName> {GetName(get())}
//    factoryOf(::GetName)
    factoryOf(::GetRandomCharacter)
}

