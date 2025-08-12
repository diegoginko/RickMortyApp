package com.diegoginko.rickmortyapp.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

//Modulo para inyecciones independientes por plataforma
expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null){
    startKoin {
        //Invoca la configuracion
        config?.invoke(this)
        modules(
            domainModule,
            dataModule,
            uiModule,
            platformModule()
        )
    }
}