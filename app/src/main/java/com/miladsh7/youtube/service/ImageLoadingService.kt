package com.miladsh7.youtube.service

import com.miladsh7.youtube.view.YoutubeImageView

interface ImageLoadingService {
    fun load(imageView: YoutubeImageView, imageUrl: String)
}