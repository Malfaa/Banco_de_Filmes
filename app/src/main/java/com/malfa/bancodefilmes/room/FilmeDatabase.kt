package com.malfa.bancodefilmes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.malfa.bancodefilmes.utils.Constantes
import com.malfa.bancodefilmes.retrofit.models.Filme

@Database(entities = [Filme::class], version = 1, exportSchema = false)
//@TypeConverter()
abstract class FilmeDatabase : RoomDatabase(){

    abstract val dao: FilmeDao

    companion object {
        @Volatile
        private var INSTANCE: FilmeDatabase? = null

        fun getInstance(context: Context): FilmeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FilmeDatabase::class.java,
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

/*
package com.malfa.bancodefilmes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.malfa.bancodefilmes.utils.Constantes
import com.malfa.bancodefilmes.retrofit.models.Filme

@Database(entities = [Filme::class], version = 1, exportSchema = false)
abstract class FilmeDatabase : RoomDatabase(){

    abstract val dao: FilmeDao

    companion object {
        @Volatile
        private lateinit var instance: FilmeDatabase

        fun getInstance(context: Context): FilmeDatabase {
            synchronized(this) {
                if(!::instance.isInitialized) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FilmeDatabase::class.java,
                        Constantes.TABLE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance
        }
    }
}
 */