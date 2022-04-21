package com.miladsh7.youtube.model


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoItem(
    @Json(name = "cat_id")
    val catId: String,
    @Json(name = "creator")
    val creator: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "icon")
    val icon: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "special")
    val special: String,
    @Json(name = "time")
    val time: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "view")
    val view: String
):Parcelable