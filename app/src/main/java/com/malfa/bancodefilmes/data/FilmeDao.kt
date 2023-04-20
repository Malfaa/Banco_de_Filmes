package com.malfa.bancodefilmes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.malfa.bancodefilmes.Constantes
import com.malfa.bancodefilmes.retrofit.models.Filme

@Dao
interface FilmeDao {
    @Query("SELECT * FROM ${Constantes.TABLE_NAME}")
    fun infosFilmes(): Filme

    @Insert
    fun atualizandoFilme(filme: Filme)

    @Query("DELETE FROM ${Constantes.TABLE_NAME}")
    fun deletandoFilme()
}