package com.miladsh7.youtube.di

import com.miladsh7.youtube.api.ApiService
import com.miladsh7.youtube.service.FrescoImageLoadingService
import com.miladsh7.youtube.service.ImageLoadingService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
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
    fun provideFrescoImageLoadingService(
        frescoImageLoadingService: FrescoImageLoadingService
    ): ImageLoadingService {
        return frescoImageLoadingService
    }
}