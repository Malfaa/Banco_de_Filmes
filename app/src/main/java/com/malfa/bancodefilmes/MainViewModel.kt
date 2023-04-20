package com.malfa.bancodefilmes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malfa.bancodefilmes.repository.RepositorioImpl
import kotlinx.coroutines.launch

class MainViewModel(private val repositorioImpl: RepositorioImpl) : ViewModel(){
    val filmes = repositorioImpl.getFilme

    fun atualizandoFilme(filme: String){
        viewModelScope.launch /*(Dispatchers.IO)*/ {
            repositorioImpl.deletandoFilme()
            repositorioImpl.cacheFilme(filme)
        }
    }
}