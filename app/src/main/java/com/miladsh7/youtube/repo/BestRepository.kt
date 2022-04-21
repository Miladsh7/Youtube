package com.miladsh7.youtube.repo

import com.miladsh7.youtube.model.VideoItem
import retrofit2.Response

interface BestRepository {

    suspend fun getBestVideos(): List<VideoItem>
}