package com.diegoginko.rickmortyapp.di

import com.diegoginko.rickmortyapp.data.RepositoryImpl
import com.diegoginko.rickmortyapp.data.remote.ApiService
import com.diegoginko.rickmortyapp.data.remote.paging.CharactersPagingSource
import com.diegoginko.rickmortyapp.domain.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                //Ignora los valores que no esten mapeados
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url{
                    protocol = URLProtocol.HTTPS
                    //En iOs tenes que sacar la barra al final de la url
                    host = "rickandmortyapi.com"
//                    parameters.append("page", "1")
                }
            }

        }
    }

    factoryOf(::ApiService)
    factory<Repository>{ RepositoryImpl(get(),get()) }
    factoryOf(::CharactersPagingSource)
}