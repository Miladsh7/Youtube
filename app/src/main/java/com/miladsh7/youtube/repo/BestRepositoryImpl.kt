package com.miladsh7.youtube.repo

import com.miladsh7.youtube.api.ApiService
import com.miladsh7.youtube.model.VideoItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BestRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BestRepository {
    override suspend fun getBestVideos(): List<VideoItem> {
        return apiService.getBestVideos()
    }
}

