package com.miladsh7.youtube.api

import com.miladsh7.youtube.model.VideoItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("getNewVideos.php")
    suspend fun getBanner():List<VideoItem>

    @GET("getBestVideos.php")
    suspend fun getBestVideos():List<VideoItem>

    @GET("getSpecial.php")
    suspend fun getSpecialVideo():List<VideoItem>

    companion object{
        const val BASE_URL = "http://androidsupport.ir/pack/aparat/"
    }
}