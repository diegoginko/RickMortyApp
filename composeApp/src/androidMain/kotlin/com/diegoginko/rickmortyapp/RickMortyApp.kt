package com.diegoginko.rickmortyapp

import android.app.Application
import com.diegoginko.rickmortyapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RickMortyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin {
            //Habilita logs
            androidLogger()
            //Agrego context
            androidContext(this@RickMortyApp)
        }
    }

}