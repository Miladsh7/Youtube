package com.miladsh7.youtube.repo

import com.miladsh7.youtube.api.ApiService
import com.miladsh7.youtube.model.VideoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : NewRepository {
    override suspend fun getNewVideos(): List<VideoItem> {
        return apiService.getNewVideos()
    }
}