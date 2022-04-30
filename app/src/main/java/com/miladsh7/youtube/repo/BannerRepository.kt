package com.miladsh7.youtube.repo

import com.miladsh7.youtube.model.VideoItem

interface BannerRepository {
    suspend fun getBanner(): List<VideoItem>
}