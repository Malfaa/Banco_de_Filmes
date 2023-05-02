package com.malfa.bancodefilmes.retrofit

import com.malfa.bancodefilmes.utils.Constantes
import com.malfa.bancodefilmes.retrofit.models.Filme
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object OmdbApi{
    private const val BASE_URL = "http://www.omdbapi.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(OmdbHttpClient.getClient())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService : OmdbApiService by lazy {
        retrofit.create(OmdbApiService::class.java)
    }
}

interface OmdbApiService {
    //Buscar filme por Título
    @GET("?")
    suspend fun getFilmeTitulo(
        @Query("t=")
        titulo: String,
        @Query("plot=")
        plot: String = "full",
        @Query("apikey=")
        api: String = Constantes.APIKEY // FIXME: talvez tenha que colocar os valores dos parâmetros no repo
    ) : Filme
    //Buscar filme por ID
    @GET("?")
    suspend fun getFilmeId(
        @Query("i")
        titulo: String,
        @Query("plot=")
        plot: String = "full",
        @Query("apikey=")
        api: String = Constantes.APIKEY
    ) : Filme
}