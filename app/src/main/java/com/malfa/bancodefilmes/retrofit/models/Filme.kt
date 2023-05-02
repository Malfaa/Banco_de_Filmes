package com.malfa.bancodefilmes.retrofit.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.malfa.bancodefilmes.utils.Constantes
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
//@JsonClass(generateAdapter = true)
@Entity(tableName = Constantes.ENTITY_NAME)
data class Filme (
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    @Json(name = "Title")
    val Title: String?,
    @Json(name = "Year")
    val Year: String?,
    @Json(name = "Rated")
    val Rated: String?,
    @Json(name = "Released")
    val Released: String?,
    @Json(name = "Runtime")
    val Runtime: String?,
    @Json(name = "Genre")
    val Genre: String?,
    @Json(name = "Director")
    val Director: String?,
    @Json(name = "Writer")
    val Writer: String?,
    @Json(name = "Actors")
    val Actors: String?,
    @Json(name = "Plot")
    val Plot: String?,
    @Json(name = "Language")
    val Language: String?,
    @Json(name = "Country")
    val Country: String?,
    @Json(name = "Awards")
    val Awards: String?,
    @Json(name = "Poster")
    val Poster: String?,
    @Json(name = "Ratings")
    val Ratings: List<Rating>?,
    @Json(name = "Metascore")
    val Metascore: String?,
    @Json(name = "imdbRating")
    val imdbRating: String?,
    @Json(name = "imdbVotes")
    val imdbVotes: String?,
    @Json(name = "imdbID")
    val imdbID: String?,
    @Json(name = "Type")
    val Type: String?,
    @Json(name = "DVD")
    val DVD: String?,
    @Json(name = "BoxOffice")
    val BoxOffice: String?,
    @Json(name = "Production")
    val Production: String?,
    @Json(name = "Website")
    val Website: String?,
    @Json(name = "Response")
    val Response: Boolean
): Parcelable