package com.malfa.bancodefilmes

import android.app.Application
import com.malfa.bancodefilmes.data.FilmeDatabase
import com.malfa.bancodefilmes.retrofit.OmdbApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    //koin
    override fun onCreate() {
        super.onCreate()

        val modulo = module {
            single { FilmeDatabase.getInstance(this@MyApp)}
            single { OmdbApi }
//            single { Repositorio()}
//            viewModel{}
        }
        startKoin {
            androidContext(this@MyApp)
            modules(modulo)
        }
    }
}