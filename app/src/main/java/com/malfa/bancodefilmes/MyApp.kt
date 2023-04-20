package com.malfa.bancodefilmes

import android.app.Application
import com.malfa.bancodefilmes.data.FilmeDatabase
import com.malfa.bancodefilmes.repository.RepositorioImpl
import com.malfa.bancodefilmes.retrofit.OmdbApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    //koin
    override fun onCreate() {
        super.onCreate()

        val modulo = module {
            single { FilmeDatabase.getInstance(this@MyApp)}
            single { OmdbApi }
            single { RepositorioImpl( get() as OmdbApi, get() as FilmeDatabase) }
            viewModel{ MainViewModel(get() as RepositorioImpl)}
        }

        startKoin {
            androidContext(this@MyApp)
            modules(modulo)
        }
    }
}