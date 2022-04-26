package com.miladsh7.youtube.repo

import androidx.lifecycle.LiveData
import com.miladsh7.youtube.model.Channel
import com.miladsh7.youtube.model.VideoItem

interface SpecialChannelRepository {

    suspend fun insert(channel: Channel)
    fun get(): LiveData<List<Channel>>
}