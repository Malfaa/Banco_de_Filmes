package com.malfa.bancodefilmes

import android.app.Application
import com.malfa.bancodefilmes.data.FilmesDatabase
import com.malfa.bancodefilmes.repository.Repositorio
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

class MyApp : Application() {
    //koin
    override fun onCreate() {
        super.onCreate()

        val modulo = module {
            single { FilmesDatabase.getInstance(this@MyApp)}
//            single { OmdbApi }
//            single { Repositorio()}
//            viewModel{
//
//            }
        }
        startKoin {
            androidContext(this@MyApp)
            modules(modulo)
        }
    }
}