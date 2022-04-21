package com.miladsh7.youtube.repo

import com.miladsh7.youtube.model.VideoItem

interface SpecialRepository {

    suspend fun getSpecialVideo():List<VideoItem>
}