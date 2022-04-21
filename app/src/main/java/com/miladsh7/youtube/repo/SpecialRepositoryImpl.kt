package com.miladsh7.youtube.repo

import com.miladsh7.youtube.api.ApiService
import com.miladsh7.youtube.model.VideoItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpecialRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : SpecialRepository {
    override suspend fun getSpecialVideo(): List<VideoItem> {
        return apiService.getSpecialVideo()
    }
}