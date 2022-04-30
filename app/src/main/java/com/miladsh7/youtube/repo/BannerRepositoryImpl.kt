package com.miladsh7.youtube.repo

import com.miladsh7.youtube.api.ApiService
import com.miladsh7.youtube.model.VideoItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BannerRepository {
    override suspend fun getBanner(): List<VideoItem> {
        return apiService.getBanner()
    }
}