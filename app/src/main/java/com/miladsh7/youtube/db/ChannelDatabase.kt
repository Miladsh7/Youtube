package com.miladsh7.youtube.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.miladsh7.youtube.model.Channel

@Database(entities = [Channel::class], version = 1, exportSchema = false)
abstract class ChannelDatabase: RoomDatabase() {
    abstract fun getChannel():ChannelDao
}