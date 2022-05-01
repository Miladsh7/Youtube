package com.miladsh7.youtube

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class YoutubeApp:Application(){
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
