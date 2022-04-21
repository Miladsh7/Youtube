package com.miladsh7.youtube.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.miladsh7.youtube.api.ApiService
import com.miladsh7.youtube.db.ChannelDao
import com.miladsh7.youtube.db.ChannelDatabase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.migration.DisableInstallInCheck
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@DisableInstallInCheck
object YoutubeModule {

    private val moshi = Moshi.Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofitInstance() = Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideChannelDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(app, ChannelDatabase::class.java, "channel_db").build()

    @Provides
    @Singleton
    fun provideChannelDao(channelDatabase: ChannelDatabase) = channelDatabase.getChannel()
}