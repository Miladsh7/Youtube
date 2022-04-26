package com.miladsh7.youtube.repo

import androidx.lifecycle.LiveData
import com.miladsh7.youtube.db.ChannelDao
import com.miladsh7.youtube.model.Channel
import com.miladsh7.youtube.model.VideoItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpecialChannelRepositoryImpl @Inject constructor(
    private val channelDao: ChannelDao
) : SpecialChannelRepository {
    override suspend fun insert(channel: Channel) {
       return channelDao.insert(channel)
    }

    override fun get(): LiveData<List<Channel>> {
        return channelDao.getSpecial()
    }
}