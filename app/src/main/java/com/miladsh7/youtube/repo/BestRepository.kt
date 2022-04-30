package com.miladsh7.youtube.repo

import com.miladsh7.youtube.model.VideoItem

interface BestRepository {
    suspend fun getBestVideo(): List<VideoItem>
}