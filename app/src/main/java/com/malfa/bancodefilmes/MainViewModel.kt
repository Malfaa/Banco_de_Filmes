package com.malfa.bancodefilmes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malfa.bancodefilmes.repository.Repositorio
import com.malfa.bancodefilmes.retrofit.models.Filme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

interface IMainViewModel {
    val filme: LiveData<Filme>

    val filmes: LiveData<List<Filme>>
    //mexer no dao, database, viewmodel pra listar todos os filmes
    fun atualizandoFilme(filme: String)
}

class MainViewModel(private val repositorio: Repositorio) : ViewModel(), IMainViewModel {
    override val filme = repositorio.getFilme

    override val filmes = repositorio.getFilmes

    override fun atualizandoFilme(filme: String){
        try {
            viewModelScope.launch( Dispatchers.IO ) {
                repositorio.deletandoFilme()
                repositorio.cacheFilme(filme)
            }
            Log.d("ViewModel", "Data atualizada")
        }catch (e: Exception){
            Log.e("Error", e.message.toString())
        }

    }
}

class MainViewModelPreview : IMainViewModel {
    override val filme: LiveData<Filme>
        get() = TODO("Not yet implemented")

    override val filmes: LiveData<List<Filme>>
        get() = TODO("Not yet implemented")

    override fun atualizandoFilme(filme: String) {
        TODO("Not yet implemented")
    }
}