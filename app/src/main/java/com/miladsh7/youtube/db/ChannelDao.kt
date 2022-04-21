package com.miladsh7.youtube.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miladsh7.youtube.model.Channel

@Dao
interface ChannelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(channel: Channel)

    @Query("SELECT *from tbl_channel order by title_channel & image_channel")
    suspend fun getChannel(): LiveData<List<Channel>>
}