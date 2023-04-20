package com.malfa.bancodefilmes.repository

import com.malfa.bancodefilmes.data.FilmeDatabase
import com.malfa.bancodefilmes.retrofit.OmdbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface Repositorio{
    suspend fun cacheFilme(filme : String)
    suspend fun deletandoFilme()
}

class RepositorioImpl(private val api: OmdbApi, private val database : FilmeDatabase) : Repositorio {
    //Network & Database
    val getFilme = database.dao.infosFilmes()

    override suspend fun cacheFilme(filme: String) {
        withContext(Dispatchers.IO){
            val response = api.retrofitService.getFilmeTitulo(filme)
            database.dao.atualizandoFilme(response)
        }
    }
    override suspend fun deletandoFilme() {
        withContext(Dispatchers.IO){
            database.dao.deletandoFilme()
        }
    }
}