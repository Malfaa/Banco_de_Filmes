package com.malfa.bancodefilmes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.malfa.bancodefilmes.Constantes
import com.malfa.bancodefilmes.retrofit.models.Filme

@Database(entities = [Filme::class], version = 1, exportSchema = false)
abstract class FilmesDatabase : RoomDatabase(){

    abstract val dao: FilmeDao

    companion object {
        @Volatile
        private var INSTANCE: FilmesDatabase?= null

        fun getInstance(context: Context): FilmesDatabase{
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FilmesDatabase::class.java,
                        Constantes.TABLE_NAME
                    )
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}