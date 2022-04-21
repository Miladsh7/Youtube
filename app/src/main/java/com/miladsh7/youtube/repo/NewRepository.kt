package com.miladsh7.youtube.repo

import com.miladsh7.youtube.model.VideoItem

interface NewRepository {

    suspend fun getNewVideos(): List<VideoItem>
}