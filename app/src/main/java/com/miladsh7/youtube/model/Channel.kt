package com.miladsh7.youtube.model

import android.graphics.drawable.Drawable
import androidx.room.Entity

@Entity(tableName = "tbl_channel")
data class Channel (
    val titleChannel: String,
    val imageChannel: Drawable
        )