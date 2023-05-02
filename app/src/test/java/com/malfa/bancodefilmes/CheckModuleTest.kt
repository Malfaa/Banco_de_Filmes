package com.malfa.bancodefilmes

import com.malfa.bancodefilmes.room.FilmeDatabase
import com.malfa.bancodefilmes.repository.RepositorioImpl
import com.malfa.bancodefilmes.retrofit.OmdbApi
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class CheckModuleTest : KoinTest {
    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAllModules() {
        val modulo = module {
            single { FilmeDatabase.getInstance(androidContext())}
            single { OmdbApi }
            single { RepositorioImpl( get() as OmdbApi, get() as FilmeDatabase) }
            viewModel{ MainViewModel(get() as RepositorioImpl)}
        }

        modulo.verify()
    }
}