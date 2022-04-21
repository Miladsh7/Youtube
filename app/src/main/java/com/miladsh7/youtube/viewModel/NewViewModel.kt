package com.miladsh7.youtube.viewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miladsh7.youtube.R
import com.miladsh7.youtube.db.ChannelDatabase
import com.miladsh7.youtube.model.Channel
import com.miladsh7.youtube.repo.NewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class NewViewModel @Inject constructor(
    private val newRepository: NewRepository
):ViewModel() {

    lateinit var database: ChannelDatabase
    private var context:Context? = null
    init {
        getNewVideo()
    }

    private fun getNewVideo() = viewModelScope.launch {
        newRepository.getNewVideos().filter { videoItem ->
            videoItem.id.contains("10") && videoItem.id.contains("7") && videoItem.id.contains("6")
            when(videoItem.catId){
                "8" ->{
                    val trtImage=
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.trt, null)
                    val channel = trtImage?.let { Channel("TRT1", it) }
                    val channelDao = database.getChannel()
                    val newsChannel = channel?.let { channelDao.insert(it) }
                    return@launch

                }

                "4"->{
                    val cartonImage=
                        ResourcesCompat.getDrawable(context!!.resources, R.drawable.pooya, null)
                    val channel = cartonImage?.let { Channel("Pooya", it) }
                    val channelDao = database.getChannel()
                    val newsChannel = channel?.let { channelDao.insert(it) }
                    return@launch

                }
                else ->{
                    return@launch
                }
            }

        }
    }


}