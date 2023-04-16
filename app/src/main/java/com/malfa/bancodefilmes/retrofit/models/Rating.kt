package com.malfa.bancodefilmes.retrofit.models

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @Json(name = "Source")
    val Source: String,
    @Json(name = "Value")
    val Value: String
): Parcelable