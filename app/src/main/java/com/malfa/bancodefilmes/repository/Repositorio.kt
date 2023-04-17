package com.malfa.bancodefilmes.repository

import com.malfa.bancodefilmes.data.FilmeDatabase
import com.malfa.bancodefilmes.retrofit.OmdbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface IRepositorio{

}

class Repositorio(private val api: OmdbApi, private val database : FilmeDatabase) : IRepositorio {

    //Network


    //Database
    val getFilme = database.dao.infosFilmes()

    //    suspend fun recuperaFilme(){
//        withContext(Dispatchers.IO){
//            database.dao.infosFilmes()
//        }
//    }
    suspend fun refreshLinhas(filme: String) {
        withContext(Dispatchers.IO){
            val response = api.retrofitService.getFilmeTitulo(filme)
            database.dao.atualizandoFilme(response)
        }
    }
}