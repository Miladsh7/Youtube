package com.miladsh7.youtube.model

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "tbl_channel")
data class Channel (
    @ColumnInfo(name = "title_channel")
    val titleChannel: String,
    @ColumnInfo(name = "image_channel")
    val imageChannel: Drawable
        )
