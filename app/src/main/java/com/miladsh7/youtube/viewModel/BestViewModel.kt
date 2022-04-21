package com.miladsh7.youtube.viewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miladsh7.youtube.R
import com.miladsh7.youtube.db.ChannelDatabase


import com.miladsh7.youtube.model.VideoItem
import com.miladsh7.youtube.repo.BestRepository
import dagger.hilt.android.lifecycle.HiltViewModel


import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class BestViewModel @Inject constructor(
    private val bestRepository: BestRepository
) : ViewModel() {

    private val bestVideoLiveData = MutableLiveData<List<VideoItem>>()

    lateinit var database: ChannelDatabase
    private var context:Context?=null
    private fun getBestVideo() = viewModelScope.launch {

        bestRepository.getBestVideos().filter { videoItem ->
        videoItem.id.startsWith("1") && videoItem.id.endsWith("5")
            when(videoItem.catId){
                "1" -> {
                    val linuxImage =
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.linux, null)
                    val channel = linuxImage?.let { Channel("Linux", it) }
                    val channelDao = database.getChannel()
                    val bestChannel = channel?.let { channelDao.insert(it) }
                    return@launch


                }
                "2" -> {
                    val androidDeveloperImage =
                        ResourcesCompat.getDrawable(context!!.resources,R.drawable.android_developer,null)
                    val channel = androidDeveloperImage?.let { Channel("Android Developer",it) }
                    val channelDao = database.getChannel()
                    val bestChannel = channel?.let { channelDao.insert(it) }
                    return@launch
                }
                else -> {
                    print("nothing cat_id")
                    return@launch
                }
            }

        }.let {
            bestVideoLiveData.postValue(it)

        }

    }

}