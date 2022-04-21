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
import com.miladsh7.youtube.repo.NewRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class SpecialViewModel @Inject constructor(
    private val newRepository: NewRepository
) : ViewModel() {

    private val specialLiveData = MutableLiveData<VideoItem>()
    lateinit var database: ChannelDatabase

    @SuppressLint("StaticFieldLeak")
    private var context: Context? = null

    init {
        getSpecialVideo()
    }
    private fun getSpecialVideo() = viewModelScope.launch {
        newRepository.getNewVideos().filter { videoItem ->
            videoItem.id.startsWith("8")
                    && videoItem.id.endsWith("9")
            when (videoItem.catId) {
                "5" -> {
                    val varzeshImage =
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.varzesh_3, null)
                    val channel = varzeshImage?.let { Channel("Varzesh3", it) }
                    val channelDao = database.getChannel()
                    val specialChannel = channel?.let { channelDao.insert(channel) }
                    return@launch

                }
                else -> {
                    print("Nothing cat_id")
                    return@launch
                }

            }

        }.let {

        }
    }
}