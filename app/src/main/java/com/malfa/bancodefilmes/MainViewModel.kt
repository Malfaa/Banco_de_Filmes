package com.malfa.bancodefilmes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malfa.bancodefilmes.repository.RepositorioImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repositorioImpl: RepositorioImpl) : ViewModel(){
    val filmes = repositorioImpl.getFilme

    fun atualizandoFilme(filme: String){
        try {
            viewModelScope.launch( Dispatchers.IO ) {
                repositorioImpl.deletandoFilme()
                repositorioImpl.cacheFilme(filme)
            }
            Log.d("ViewModel", "Data atualizada")
        }catch (e: Exception){
            Log.e("Error", e.message.toString())
        }

    }
}