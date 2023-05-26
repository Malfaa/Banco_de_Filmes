package com.malfa.bancodefilmes.repository

import androidx.lifecycle.LiveData
import com.malfa.bancodefilmes.retrofit.models.Filme

interface Repositorio {
    val getFilme : LiveData<Filme>
    
    suspend fun cacheFilme(filme : String)
    suspend fun deletandoFilme()
}