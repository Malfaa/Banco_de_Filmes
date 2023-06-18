package com.malfa.bancodefilmes.repository

import com.malfa.bancodefilmes.room.FilmeDatabase
import com.malfa.bancodefilmes.retrofit.OmdbApi
import com.malfa.bancodefilmes.utils.Constantes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositorioImpl(private val api: OmdbApi, private val database : FilmeDatabase) : Repositorio {
    //Network & Database
    override val getFilme = database.dao.infosFilme()

    override val getFilmes = database.dao.infosFilmes()

    override suspend fun cacheFilme(filme: String) {
        withContext(Dispatchers.IO){
            val response = api.retrofitService.getFilmeTitulo(api = Constantes.APIKEY, filme, plot = "full" )
            database.dao.atualizandoFilme(response)
        }
    }
    override suspend fun deletandoFilme() {
        withContext(Dispatchers.IO){
            database.dao.deletandoFilme()
        }
    }
}