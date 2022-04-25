package com.miladsh7.youtube.home

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miladsh7.youtube.R
import com.miladsh7.youtube.db.ChannelDatabase
import com.miladsh7.youtube.model.Channel
import com.miladsh7.youtube.model.VideoItem
import com.miladsh7.youtube.repo.SpecialRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel(
    private val specialRepository: SpecialRepository
):ViewModel() {

    private var specialLiveData = MutableLiveData<List<VideoItem>>()
    lateinit var database: ChannelDatabase

    @SuppressLint("StaticFieldLeak")
    private var context: Context? = null

    init {
        getSpecialVideo()
    }

    private fun getSpecialVideo() = viewModelScope.launch {

        specialRepository.getSpecialVideo().filter { videoItem ->
            videoItem.id.startsWith("2") && videoItem.id.endsWith("10")
            when (videoItem.catId) {
                "2" -> {
                    val androidDeveloper =
                        ResourcesCompat.getDrawable(
                            context!!.resources,
                            R.drawable.android_developer,
                            null
                        )
                    val channel = androidDeveloper?.let { Channel("Android Developer", it) }
                    val channelDao = database.getChannel()
                    val specialChannel = channel?.let { channelDao.insert(channel) }
                    return@launch
                }
                "4" -> {
                    val pooya =
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.pooya, null)
                    val channel = pooya?.let { Channel("pooya", it) }
                    val channelDao = database.getChannel()
                    val specialChannel = channel?.let { channelDao.insert(channel) }
                    return@launch
                }

                "5" -> {
                    val varzesh3 =
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.varzesh_3, null)
                    val channel = varzesh3?.let { Channel("Varzesh3", it) }
                    val channelDao = database.getChannel()
                    val specialChannel = channel?.let { channelDao.insert(channel) }
                    return@launch
                }

                "8" -> {
                    val trt =
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.trt, null)
                    val channel = trt?.let { Channel("TRT1", it) }
                    val channelDao = database.getChannel()
                    val specialChannel = channel?.let { channelDao.insert(channel) }
                    return@launch
                }
                else -> {
                    throw IllegalAccessException("Invalid not cat_id")
                }
            }
        }.let {
            specialLiveData.postValue(it)
        }

    }

}